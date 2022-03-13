package com.wmxkb.mapper;


import com.wmxkb.entity.water_Infos;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 让springboot识别为mapper
@Mapper
public interface water_InfosMapper {

    // 方法名要和xml文件id一致
    public water_Infos selectBylocationandfloor(String location , int floor);

    public List<water_Infos> selectBylocation(String location);
}
