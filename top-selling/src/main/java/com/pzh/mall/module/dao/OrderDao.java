package com.pzh.mall.module.dao;

import com.pzh.mall.module.domain.Sales;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/5 9:59
 * @Version 1.0
 */
@Mapper
public interface OrderDao {

    /**
     * 保存订单
     * @param payment
     * @param postFee
     * @param userId
     * @param userNote
     */
    void saveOrder(long id, BigDecimal payment, BigDecimal postFee, long userId, String userNote);

    /**
     * 保存订单商品
     * @param itemId
     * @param orderId
     * @param num
     */
    void saveOrderItem(long itemId, long orderId, int num);

    /**
     * 获取商品某一天内的销量
     * @param beginTime
     * @param endTime
     * @return
     */
    List<Sales> listSales(String beginTime, String endTime);
}
