package com.wmxkb.controller;

import com.wmxkb.entity.Asset;
import com.wmxkb.mapper.AssetMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
// 扫描映射（Mapper）
@MapperScan("com.wmxkb.mapper")
public class AssetController {

    // 注入AssetService
    @Autowired
    private AssetMapper assetMapper;

    // 映射请求，GET http://localhost:8080/login
    @RequestMapping("/write")
    public Object write(@RequestParam("date")String date, @RequestParam("value")String value){
        System.out.println(date);
        int result = 0;
        List<Asset> list;
        try {
            result = assetMapper.write_date(date, Double.parseDouble(value));
            System.out.println("插入成功:" + result);
            result = 0;
        }catch (Exception e){
            result = 1;
            System.out.println("插入失败:-1");
        }finally {
            list = assetMapper.read_all();
        }
        if(result == 0){
            return list;
        }else {
            return result;
        }
    }

}
