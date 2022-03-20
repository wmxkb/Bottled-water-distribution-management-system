package com.wmxkb.controller;


import com.wmxkb.service.orderService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

// 扫描映射（Mapper）
@MapperScan("com.wmxkb.mapper")
public class commodityController {
    @Autowired
    private com.wmxkb.service.commodityService commodityService;

    @RequestMapping("/selectByName")
    public Object selectByName(@RequestParam("orderGoods")String orderGoods){

        System.out.println(orderGoods + " " +commodityService.selectByName(orderGoods));
        return commodityService.selectByName(orderGoods);
    }
}
