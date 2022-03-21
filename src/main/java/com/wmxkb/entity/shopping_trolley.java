package com.wmxkb.entity;

public class shopping_trolley {
    private String waterType;
    private Double price;
    private Integer count;
    private String userid;
    private String location;
    private Integer floor;

    // 构造函数
    public shopping_trolley(){}



    // get方法
    public String getWaterType(){
        return this.waterType;
    }
    public Double getPrice(){
        return this.price;
    }
    public Integer getCount(){
        return this.count;
    }
    public String getUserid(){
        return this.userid;
    }

    public Integer getFloor() {
        return floor;
    }

    public String getLocation() {
        return location;
    }
}
