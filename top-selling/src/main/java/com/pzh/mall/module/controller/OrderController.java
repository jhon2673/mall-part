package com.pzh.mall.module.controller;

import com.pzh.mall.common.ResultMsg;
import com.pzh.mall.module.domain.Rank;
import com.pzh.mall.module.service.OrderService;
import com.pzh.mall.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/5 9:38
 * @Version 1.0
 */
@Controller
@RequestMapping("/myOrder")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    // 存储订单商品项
    private static final List<Map<Long, Integer>> itemList = new ArrayList<>();

    @Autowired
    private OrderService orderService;

    @RequestMapping("/generateOrder")
    @ResponseBody
    public ResultMsg generateOrder(BigDecimal payment, int postType, String userNote) {
        LOGGER.info("提交订单 payment:" + payment + " postType:" + postType + " userNote:" + userNote);
        ResultMsg resultMsg = new ResultMsg();
        try {
            BigDecimal postFee = new BigDecimal(0);
            if (postType == 1) {
                LOGGER.info("免邮");
            }

            IdWorker worker = new IdWorker(1,1,1);
            long id = worker.nextId();
            LOGGER.info("生成订单id:" + id);
            orderService.saveOrder(id, payment, postFee, 1002, userNote, itemList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/loadSales")
    @ResponseBody
    public ResultMsg loadSales() {
        LOGGER.info("载入商品销量数据到redis...");
        ResultMsg resultMsg = new ResultMsg();
        try {
            orderService.loadSales();
            LOGGER.info("载入数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("载入数据失败");
        }

        return resultMsg;
    }

    @RequestMapping("/getRankList")
    @ResponseBody
    public ResultMsg getRankList(int days) {
        LOGGER.info("获取最近几天的销售排行榜 days:" + days);
        ResultMsg resultMsg = new ResultMsg();
        try {
            List<Rank> rankList = orderService.getRankList(days);
            resultMsg.setData(rankList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("操作失败");
        }

        return resultMsg;
    }

}
