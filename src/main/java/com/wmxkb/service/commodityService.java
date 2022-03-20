package com.wmxkb.service;

import com.wmxkb.mapper.commodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commodityService {

    @Autowired
    private com.wmxkb.mapper.commodityMapper commodityMapper;

    public Double selectByName(String commodityName){
        return commodityMapper.selectByName(commodityName);
    }
}
