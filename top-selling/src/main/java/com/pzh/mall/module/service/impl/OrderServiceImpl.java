package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.OrderDao;
import com.pzh.mall.module.domain.Rank;
import com.pzh.mall.module.domain.Sales;
import com.pzh.mall.module.service.OrderService;
import com.pzh.mall.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/5 10:00
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private OrderDao orderDao;


    @Transactional
    @Override
    public void saveOrder(long id, BigDecimal payment, BigDecimal postFee, long userId, String userNote, List<Map<Long, Integer>> itemList) {
        String key = "rank:" + DateUtil.getDate(0, new SimpleDateFormat("yyyyMMdd"));

        orderDao.saveOrder(id, payment, postFee, userId, userNote);
        // 插入订单商品表
        for (Map<Long, Integer> map : itemList) {
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                long itemId = entry.getKey();
                int num = entry.getValue();
                orderDao.saveOrderItem(itemId, id, num);

                // 更新redis销售量
                Long index = redisTemplate.opsForZSet().reverseRank(key, itemId);
                if (index != null) {
                    redisTemplate.opsForZSet().incrementScore(key, itemId, num);
                } else {
                    redisTemplate.opsForZSet().add(key, itemId, num);
                }
            }
        }
    }

    @Override
    public void loadSales() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i > -3; i--) {
            String beginTime = DateUtil.getDate(i, formatter) + " 00:00:00";
            String endTime = DateUtil.getDate(i, formatter) + " 23:59:59";
            LOGGER.info("开始时间:" + beginTime + " 结束时间:" + endTime);
            String redisKey = "rank:" + DateUtil.getDate(i, new SimpleDateFormat("yyyyMMdd"));
            LOGGER.info("redisKey:" + redisKey);

            List<Sales> salesList = orderDao.listSales(beginTime, endTime);
            if (salesList != null && salesList.size() > 0) {
                for (Sales sales : salesList) {
                    // 加载到redis
                    redisTemplate.opsForZSet().add(redisKey, sales.getItemId(), sales.getSales());
                }
            }
        }
    }

    @Override
    public List<Rank> getRankList(int days) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<String> otherKeys = new ArrayList<>();
        String key = "rank:" + DateUtil.getDate(0, new SimpleDateFormat("yyyyMMdd"));
        for (int i = -1; i > -days; i--) {
            String beginTime = DateUtil.getDate(i, formatter) + " 00:00:00";
            String endTime = DateUtil.getDate(i, formatter) + " 23:59:59";
            LOGGER.info("开始时间:" + beginTime + " 结束时间:" + endTime);
            String redisKey = "rank:" + DateUtil.getDate(i, new SimpleDateFormat("yyyyMMdd"));
            LOGGER.info("redisKey:" + redisKey);

            otherKeys.add(redisKey);
        }

        // 合并指定时间范围的排行榜并存入redis
        LOGGER.info("key:" + key + " otherKeys:" + String.join(",", otherKeys));
        redisTemplate.opsForZSet().unionAndStore(key, otherKeys, "rank:union");
        // 获取指定时间范围的排行榜
        Set<ZSetOperations.TypedTuple<Object>> tuples = redisTemplate.opsForZSet().reverseRangeByScoreWithScores("rank:union", 1, 10);

        List<Rank> rankList = new ArrayList<>();
        for (ZSetOperations.TypedTuple<Object> tuple : tuples) {
            Rank rank = new Rank();
            rank.setProductName(String.valueOf(tuple.getValue()));
            rank.setSales(tuple.getScore());
            rankList.add(rank);
        }
        return rankList;
    }

}
