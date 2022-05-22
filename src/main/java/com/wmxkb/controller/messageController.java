package com.wmxkb.controller;


import com.wmxkb.entity.admin_user;
import com.wmxkb.entity.message;
import com.wmxkb.service.messageService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// 扫描映射（Mapper）
@MapperScan("com.wmxkb.mapper")
public class messageController {

    @Autowired
    private messageService messageService;
    @RequestMapping("/addMessage")
    public Object addMessage(@RequestParam("username")String username,
                             @RequestParam("isUser")int isUser,
                             @RequestParam("isAdmin")int isAdmin,
                             @RequestParam("messageText")String messageText
                             ){
        System.out.println("测试测试");
        int res = messageService.addMessage(username, isUser, isAdmin, messageText);
        return res;

    }

    @RequestMapping("/getMessage")
    public Object getMessage(@RequestParam("username")String username){
        List<message> res = messageService.getMessage(username);
        System.out.println(res.get(0));
        return res;
    }
}
