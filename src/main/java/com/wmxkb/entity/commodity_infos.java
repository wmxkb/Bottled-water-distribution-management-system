package com.wmxkb.entity;

public class commodity_infos {
    private String commodityName;
    private int commodityCount;
    private int floor;
    private String location;
    private int commodityType;

    // 编写一个三个参数的构造方法，为后面的插入数据做准备
    public commodity_infos(String commodityName, int commodityCount, int floor, String location, int commodityType){
        this.commodityName = commodityName;
        this.commodityCount = commodityCount;
        this.floor = floor;
        this.location = location;
        this.commodityType = commodityType;
    }
    // 无参构造方法
    public commodity_infos(){}


    public int getCommodityCount() {
        return commodityCount;
    }

    public String getCommodityName(){
        return commodityName;
    }

    public int getFloor(){
        return this.floor;
    }

    public String getLocation(){
        return this.location;
    }

    public void setCommodityCount(int commodityCount) {
        this.commodityCount = commodityCount;
    }

    public int getCommodityType() {
        return commodityType;
    }
}
