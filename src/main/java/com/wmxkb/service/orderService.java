package com.wmxkb.service;

import com.wmxkb.entity.order_main;
import com.wmxkb.mapper.orderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
