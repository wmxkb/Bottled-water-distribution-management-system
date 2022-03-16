package com.wmxkb.entity;

public class order {

    private String orderNumber;
    private String orderTime;
    private String orderUserId;
    private Double orderPrice;

    public order(){}

    public String getOrderNumber(){return this.orderNumber;}
    public String getOrderTime(){return this.orderTime;}
    public String getOrderUserId(){return this.orderUserId;}
    public Double getOrderPrice(){return this.orderPrice;}
}
