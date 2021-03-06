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

    public int selectSingle(String location, int floor, int type);

    public List<Map<String, Object>> selectBylocation(String location);

    public List<commodity_infos> showChartsByLocation(String location);

    public int reduceCommodityCount(String location, Integer floor, Integer commodityType);

    public int addCommodityCount(String location, Integer floor, Integer commodityType, Integer Count);

    public int addWater(String location, Integer floor);
}
