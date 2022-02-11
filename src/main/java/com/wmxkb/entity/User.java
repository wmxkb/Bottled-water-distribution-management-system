package com.wmxkb.entity;
// 实体类-User
public class User {
    private  String userid;
    private  String username;
    private  String password;
    // 编写一个三个参数的构造方法，为后面的插入数据做准备
    public User(String userid, String username, String password){
        this.userid = userid;
        this.username = username;
        this.password = password;
    }
    // 无参构造方法
    public User() {}

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
}
