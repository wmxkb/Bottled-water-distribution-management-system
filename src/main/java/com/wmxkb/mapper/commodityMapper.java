package com.wmxkb.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface commodityMapper {

    public Double selectByName(String commodityName);
}
