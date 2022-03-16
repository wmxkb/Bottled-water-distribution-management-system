package com.wmxkb.controller;


import com.wmxkb.entity.order;
import com.wmxkb.service.orderService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

// 扫描映射（Mapper）
@MapperScan("com.wmxkb.mapper")
public class orderController {

    @Autowired
    private orderService orderService;

    @RequestMapping("/addOrder")
    public Object addOrderFunction(@RequestParam("orderTime")String orderTime, @RequestParam("orderUserId")String orderUserId,@RequestParam("orderGoods[]")String[] orderGoods,@RequestParam("orderCount[]")String[] orderCount,@RequestParam("orderPrice")Double orderPrice){

        System.out.println("测试");
        int res = orderService.addOrder(orderTime, orderUserId, orderPrice);
        for(int i = 0; i < orderGoods.length; i++){
            orderService.addOrderItem(res, orderGoods[i], orderCount[i]);
        }


//        return res;
        return 0;
    }
}