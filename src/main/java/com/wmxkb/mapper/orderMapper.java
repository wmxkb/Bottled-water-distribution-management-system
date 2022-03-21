package com.wmxkb.mapper;


import com.wmxkb.entity.order_item;
import com.wmxkb.entity.order_main;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface orderMapper {

    public int addOrder(order_main order_main);

    public int addOrderItem(Integer orderNumber, String orderGoods, String orderCount, String orderLocation, Integer orderFloor);

    public List<order_main> getOrderMain(String userid);

    public List<Map<String, Object>> getOrderItemByNumber(String orderNumber);
}
