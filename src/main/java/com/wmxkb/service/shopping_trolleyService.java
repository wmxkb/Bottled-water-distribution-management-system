package com.wmxkb.service;

import com.wmxkb.entity.shopping_trolley;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class shopping_trolleyService {

    @Autowired
    private com.wmxkb.mapper.shopping_trolleyMapper shopping_trolleyMapper;

    public int add(String waterType, Double price, Integer count , String userid, String location, Integer floor){
        return shopping_trolleyMapper.add(waterType, price, count, userid, location, floor);
    }

    public shopping_trolley selectBywaterType(String waterType){
        return shopping_trolleyMapper.selectBywaterType(waterType);
    }

    public shopping_trolley selectByMainMessage(String waterType, String userid, String location, Integer floor){
        return  shopping_trolleyMapper.selectByMainMessage(waterType, userid, location, floor);
    }

    public int updateCount(Integer count, String waterType, String userid, String location, Integer floor){
        return  shopping_trolleyMapper.updateCount(count, waterType, userid, location, floor);
    }

    public List<shopping_trolley> selectByUserid(String userid){
        return shopping_trolleyMapper.selectByUserid(userid);
    }

    public int deleteItem(String waterType, String userid, String location, Integer floor){
        return shopping_trolleyMapper.deleteItem(waterType, userid, location, floor);
    }

    public int deleteAll(String userid){
        return shopping_trolleyMapper.deleteAll(userid);
    }
}
