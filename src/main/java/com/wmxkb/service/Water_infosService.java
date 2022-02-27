package com.wmxkb.service;

import com.wmxkb.entity.Water_infos;
import com.wmxkb.mapper.Water_infosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Water_infosService {
    @Autowired
    private Water_infosMapper water_infosMapper;

    public Water_infos selectBylocationandfloor(String location , int floor){
        return this.water_infosMapper.selectBylocationandfloor(location, floor);

    }

    public List<Water_infos> selectBylocation(String location){
        return this.water_infosMapper.selectBylocation(location);
    }
}
