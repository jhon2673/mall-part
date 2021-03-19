package com.pzh.mall.module.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/4 10:00
 * @Version 1.0
 */
public class CartItem implements Serializable {
    private static final long serialVersionUID = 7547043083726530718L;

    private Long itemId;

    private String itemName;

    private String productSpecs;

    private String pic;

    private BigDecimal price;

    private Integer quantity;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getProductSpecs() {
        return productSpecs;
    }

    public void setProductSpecs(String productSpecs) {
        this.productSpecs = productSpecs;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
