package com.wmxkb.entity;

public class order_item {
    private Integer orderNumber;
    private String orderGoods;
    private String orderCount;

    public order_item(){}

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getOrderCount() {
        return orderCount;
    }

    public String getOrderGoods() {
        return orderGoods;
    }
}
