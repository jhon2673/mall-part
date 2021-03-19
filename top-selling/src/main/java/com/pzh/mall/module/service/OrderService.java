package com.pzh.mall.module.service;

import com.pzh.mall.module.domain.Rank;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/5 10:00
 * @Version 1.0
 */
public interface OrderService {

    /**
     * 保存订单
     * @param id
     * @param payment
     * @param postFee
     * @param userId
     * @param userNote
     * @param itemList
     */
    void saveOrder(long id, BigDecimal payment, BigDecimal postFee, long userId, String userNote, List<Map<Long, Integer>> itemList);


    /**
     * 将商品销量数据载入redis
     */
    void loadSales();

    /**
     * 获取最近几天的销售排行榜
     * @param days
     * @return
     */
    List<Rank> getRankList(int days);

}
