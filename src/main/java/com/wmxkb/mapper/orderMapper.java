package com.wmxkb.mapper;


import com.wmxkb.entity.order_main;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface orderMapper {

    public int addOrder(order_main order_main);

    public int addOrderItem(Integer orderNumber, String orderGoods, String orderCount);
}
