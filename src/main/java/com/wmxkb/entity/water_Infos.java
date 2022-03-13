package com.wmxkb.entity;

public class water_Infos {
    private int bigWater;
    private int smallWater;
    private int floor;
    private String location;

    // 编写一个三个参数的构造方法，为后面的插入数据做准备
    public water_Infos(int bigWater, int smallWater, int floor, String location){
        this.bigWater = bigWater;
        this.smallWater = smallWater;
        this.floor = floor;
        this.location = location;
    }
    // 无参构造方法
    public water_Infos(){}


    public int getSmallWater(){
        return this.smallWater;
    }

    public int getBigWater(){
        return this.bigWater;
    }

    public int getFloor(){
        return this.floor;
    }

    public String getLocation(){
        return this.location;
    }
}
