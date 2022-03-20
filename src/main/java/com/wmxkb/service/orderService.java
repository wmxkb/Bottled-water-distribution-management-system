package com.wmxkb.service;

import com.wmxkb.entity.order_item;
import com.wmxkb.entity.order_main;
import com.wmxkb.mapper.orderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class orderService {

    @Autowired
    private orderMapper orderMapper;


    public int addOrder(order_main order_main){
        return orderMapper.addOrder(order_main);
    }

    public int addOrderItem(Integer orderNumber, String orderGoods, String orderCount){
        return orderMapper.addOrderItem(orderNumber,orderGoods,orderCount);
    }

    public List<order_main> getOrderMain(String userid){
        return orderMapper.getOrderMain(userid);
    }
    public List<Map<String, Object>> getOrderItemByNumber(String orderNumber){
        return orderMapper.getOrderItemByNumber(orderNumber);
    }

}
