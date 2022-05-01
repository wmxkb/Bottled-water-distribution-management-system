package com.wmxkb.service;
import com.wmxkb.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private com.wmxkb.mapper.userMapper userMapper;
    // 接口方法
    public user login_check(String username, String password){
        return this.userMapper.login_check(username, password);
    }

    public int register(String username, String password, String userid){
        return  this.userMapper.register(username, password, userid);
    }

    public user searchUser(String username){
        return this.userMapper.searchUser(username);
    }

}
