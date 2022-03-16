package com.wmxkb.service;

import com.wmxkb.entity.order;
import com.wmxkb.mapper.orderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {

    @Autowired
    private orderMapper orderMapper;


    public int addOrder(String orderTime, String orderUserId , Double orderPrice){
        return orderMapper.addOrder(orderTime,orderUserId,orderPrice);
    }

    public int addOrderItem(Integer orderNumber, String orderGoods, String orderCount){
        return orderMapper.addOrderItem(orderNumber,orderGoods,orderCount);
    }
}
