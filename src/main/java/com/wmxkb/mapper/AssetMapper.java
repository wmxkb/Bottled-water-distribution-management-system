package com.wmxkb.mapper;


import com.wmxkb.entity.Asset;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

// 让springboot识别为mapper
@Mapper
public interface AssetMapper {

    // 方法名要和xml文件id一致
    // 写入数据
    public int write_date(String date, Double value);
    // 读取所有数据
    public List<Asset> read_all();

}
