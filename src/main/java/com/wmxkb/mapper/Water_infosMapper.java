package com.wmxkb.mapper;


import com.wmxkb.entity.Water_infos;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// 让springboot识别为mapper
@Mapper
public interface Water_infosMapper {

    // 方法名要和xml文件id一致
    public Water_infos selectBylocationandfloor(String location , int floor);

    public List<Water_infos> selectBylocation(String location);
}
