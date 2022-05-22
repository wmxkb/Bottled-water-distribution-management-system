package com.wmxkb.controller;

import com.wmxkb.entity.admin_user;
import com.wmxkb.service.admin_userService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 扫描映射（Mapper）
@MapperScan("com.wmxkb.mapper")
public class admin_userController {

    @Autowired
    private admin_userService admin_userService;

    @RequestMapping("/admin_login")
    public Object admin_login(@RequestParam("userid")String userid, @RequestParam("keyword")String keyword){
        System.out.println(userid + ' ' + keyword);
        admin_user res = admin_userService.checkAdminUser(userid, keyword);
        if(res != null){
            return 1;
        }else{
            return 0;
        }

    }

    @RequestMapping("/addAdmin")
    public Object addAdmin(@RequestParam("userid")String userid, @RequestParam("keyword")String keyword , @RequestParam("phoneNumber")String phoneNumber){
        int res = admin_userService.addAdmin(userid, keyword, phoneNumber);
        return  res;
    }
//    addAdmin
}
