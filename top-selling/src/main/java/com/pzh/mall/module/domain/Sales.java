package com.pzh.mall.module.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/18 13:48
 * @Version 1.0
 */
public class Sales implements Serializable {
    private static final long serialVersionUID = -8437365413305494584L;

    private Long itemId;

    private Long sales;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }
}
