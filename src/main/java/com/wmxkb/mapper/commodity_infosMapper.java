package com.wmxkb.mapper;


import com.wmxkb.entity.commodity_infos;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

// 让springboot识别为mapper
@Mapper
public interface commodity_infosMapper {

    // 方法名要和xml文件id一致
    public commodity_infos selectBylocationandfloor(String location , int floor);

    public List<Map<String, Object>> selectBylocation(String location);
}
