package com.wmxkb.service;

import com.wmxkb.entity.admin_user;
import com.wmxkb.mapper.admin_userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class admin_userService {
    @Autowired
    private admin_userMapper admin_userMapper;

    public admin_user checkAdminUser(String userid, String keyword){
        return admin_userMapper.checkAdminUser(userid, keyword);
    }

    public int addAdmin(String userid, String keyword, String phoneNumber){
        return admin_userMapper.addAdmin(userid, keyword, phoneNumber);
    }
}
