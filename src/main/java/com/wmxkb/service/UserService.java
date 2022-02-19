package com.wmxkb.service;
import com.wmxkb.entity.User;
import com.wmxkb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    // 接口方法
    public User login_check(String username, String password){
        return this.userMapper.login_check(username, password);
    }

    public int register(String username, String password){
        return  this.userMapper.register(username, password);
    }

}
