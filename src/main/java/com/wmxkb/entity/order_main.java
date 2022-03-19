package com.wmxkb.entity;

public class order_main {

    private Integer orderNumber;
    private String orderTime;
    private String orderUserId;
    private Double orderPrice;

    public order_main(){}

    public order_main(Integer orderNumber, String orderTime, String orderUserId, Double orderPrice){
        this.orderNumber = orderNumber;
        this.orderTime = orderTime;
        this.orderPrice = orderPrice;
        this.orderUserId = orderUserId;
    }

    public Integer getOrderNumber(){return this.orderNumber;}
    public String getOrderTime(){return this.orderTime;}
    public String getOrderUserId(){return this.orderUserId;}
    public Double getOrderPrice(){return this.orderPrice;}
}
