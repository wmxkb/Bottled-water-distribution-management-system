package com.wmxkb.entity;
// 实体类-Asset
public class Asset {
    // 日期
    private String date;
    // 资金价值
    private Double value;

    // 编写一个三个参数的构造方法，为后面的插入数据做准备
    public Asset(String date, Double value){
        this.date = date;
        this.value = value;
    }

    // 无参构造方法
    public Asset(){}

    // 获取属性值
    public String getDate(){
        return this.date;
    }
    public double getValue(){
        return this.value;
    }
}
