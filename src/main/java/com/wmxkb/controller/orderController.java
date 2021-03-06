package com.wmxkb.controller;


import com.wmxkb.entity.order_item;
import com.wmxkb.entity.order_main;
import com.wmxkb.service.orderService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController

// 扫描映射（Mapper）
@MapperScan("com.wmxkb.mapper")
public class orderController {

    @Autowired
    private orderService orderService;

    @RequestMapping("/addOrder")
    public Object addOrderFunction(@RequestParam("orderTime")String orderTime, @RequestParam("orderUserId")String orderUserId,@RequestParam("orderGoods[]")String[] orderGoods,@RequestParam("orderCount[]")String[] orderCount,@RequestParam("orderPrice")Double orderPrice, @RequestParam("orderLocation[]")String[] orderLocation, @RequestParam("orderFloor[]")String[] orderFloor){

        System.out.println(orderFloor);
        order_main ordermain = new order_main(0, orderTime, orderUserId, orderPrice);
        orderService.addOrder(ordermain);
        for(int i = 0; i < orderGoods.length; i++){
            orderService.addOrderItem(ordermain.getOrderNumber(), orderGoods[i], orderCount[i], orderLocation[i], Integer.parseInt(orderFloor[i]));
        }


//        return res;
        return 0;
    }


    @RequestMapping("getOrderMain")
    public Object getOrderItem(@RequestParam("userid")String userid){

        List<order_main> res = orderService.getOrderMain(userid);
        System.out.println(res);
        return res;
    }

    @RequestMapping("getAllOrderMain")
    public Object getAllOrderMain(){

        List<order_main> res = orderService.getAllOrderMain();
        System.out.println(res);
        return res;
    }

    @RequestMapping("getOrderItemByNumber")
    public Object getOrderItemByNumber(@RequestParam("orderNumber")String orderNumber){
        List<Map<String, Object>> res = orderService.getOrderItemByNumber(orderNumber);
//        for (Map<String, Object> map : res) {
//            Set<String> set = map.keySet();
//            Iterator<String> it = set.iterator();
//            while (it.hasNext()) {
//                Object key = it.next();
//                Object value = map.get(key);
//                System.out.println(value);
//            }
//        }
        System.out.println(res);
        return res;
    }
//    bug
    @RequestMapping("getOrderItem")
    public Object getOrderItemNew(@RequestParam("orderNumber")String orderNumber){
        List<order_item> res = orderService.getOrderItem(orderNumber);
        System.out.println(res);
        return res;
    }


    @RequestMapping("getOrderCount")
    public Object getOrderCount(@RequestParam("username")String username){
        return orderService.getOrderMain(username).size();
    }
}
