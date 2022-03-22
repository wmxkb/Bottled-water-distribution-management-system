package com.wmxkb.service;

import com.wmxkb.entity.commodity_infos;
import com.wmxkb.mapper.commodity_infosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class commodity_infosService {
    @Autowired
    private commodity_infosMapper water_infosMapper;

    public commodity_infos selectBylocationandfloor(String location , int floor){
        return this.water_infosMapper.selectBylocationandfloor(location, floor);

    }

    public int selectSingle(String location, int floor, int type){
        return  this.water_infosMapper.selectSingle(location, floor, type);
    }

    public List<Map<String, Object>> selectBylocation(String location){
        return this.water_infosMapper.selectBylocation(location);
    }

    public int reduceCommodityCount(String location, Integer floor, Integer commodityType){
        return this.water_infosMapper.reduceCommodityCount(location, floor, commodityType);
    }

    public int addCommodityCount(String location, Integer floor, Integer commodityType, Integer Count){
        return this.water_infosMapper.addCommodityCount(location, floor, commodityType, Count);
    }
}
