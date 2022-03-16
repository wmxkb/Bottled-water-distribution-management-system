package com.wmxkb.mapper;


import com.wmxkb.entity.order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface orderMapper {

    public int addOrder(String orderTime, String orderUserId , Double orderPrice);

    public int addOrderItem(Integer orderNumber, String orderGoods, String orderCount);
}
