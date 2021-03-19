package com.pzh.mall.module.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/19 9:27
 * @Version 1.0
 */
public class Rank implements Serializable {
    private static final long serialVersionUID = 809139876150397325L;

    private String productName;

    private Double sales;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }
}
