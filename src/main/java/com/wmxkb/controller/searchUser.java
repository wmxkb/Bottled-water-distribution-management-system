package com.wmxkb.controller;
import com.wmxkb.entity.order_main;
import com.wmxkb.entity.user;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
// 扫描映射（Mapper）
@MapperScan("com.wmxkb.mapper")
public class searchUser {
    // 注入userService
    @Autowired
    private com.wmxkb.service.userService userService;
    @Autowired
    private com.wmxkb.service.orderService orderService;
    @RequestMapping("/searchUser")
    public Object searchUser(@RequestParam("username")String username){
        user res = userService.searchUser(username);
        List<order_main> res2 = orderService.getByUser(username);
        java.util.Date currTime = new java.util.Date();
        int month = currTime.getMonth()+1;//月
        double lastMonthMoney = 0;
        double allMoney = 0;
        for(int i = 0; i < res2.size(); i++){
            if(Integer.parseInt(res2.get(i).getOrderTime().substring(5, 7)) == month - 1){
                lastMonthMoney += res2.get(i).getOrderPrice();
            }
            allMoney += res2.get(i).getOrderPrice();
//            System.out.println(res2.get(i).getOrderPrice());
        }
        Map<String, String> mapres = new HashMap<>();
        mapres.put("lastMonthMoney", String.valueOf(lastMonthMoney));
        mapres.put("allMoney", String.valueOf(allMoney));
        mapres.put("sno", res.getUserid());
        mapres.put("username", res.getUsername());
        mapres.put("password", res.getPassword());
        mapres.put("phone", res.getPhone());
        mapres.put("name", res.getName());

        System.out.println(mapres);
        return mapres;
    }
}