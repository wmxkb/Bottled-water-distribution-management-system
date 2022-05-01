package com.wmxkb.entity;
// 实体类-User
public class user {
    private  String userid;
    private  String username;
    private  String password;
    private  String phone;
    private  String name;
    // 编写一个三个参数的构造方法，为后面的插入数据做准备
    public user(String userid, String username, String password, String phone, String name){
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.name = name;
    }
    // 无参构造方法
    public user() {}

    // 获取属性值
    public  String getUserid(){
        return  this.userid;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
