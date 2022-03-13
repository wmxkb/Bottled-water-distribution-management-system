package com.wmxkb.service;

import com.wmxkb.entity.water_Infos;
import com.wmxkb.mapper.water_InfosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class water_InfosService {
    @Autowired
    private water_InfosMapper water_infosMapper;

    public water_Infos selectBylocationandfloor(String location , int floor){
        return this.water_infosMapper.selectBylocationandfloor(location, floor);

    }

    public List<water_Infos> selectBylocation(String location){
        return this.water_infosMapper.selectBylocation(location);
    }
}
