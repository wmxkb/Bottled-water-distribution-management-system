package com.wmxkb.service;


import com.wmxkb.entity.Asset;
import com.wmxkb.mapper.AssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetMapper assetMapper;
    // 接口方法
    // 写入数据
    public int write_data(String date, Double value) {
        return assetMapper.write_date(date,value);
    }
    // 读取所有数据
    public List<Asset> read_all(){
        return  assetMapper.read_all();
    }
}
