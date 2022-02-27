package com.wmxkb.controller;


import com.wmxkb.entity.Water_infos;
import com.wmxkb.mapper.Water_infosMapper;
import com.wmxkb.service.Water_infosService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
// 扫描映射（Mapper）
@MapperScan("com.wmxkb.mapper")
public class getWater_infosController {

    @Autowired
    private Water_infosService water_infosService;

    // 映射请求，GET http://localhost:8080/login
//    @RequestMapping("/getWater_info")
//    public Object getWater_infos(@RequestParam("location")String location, @RequestParam("floor")int floor){
//        // System.out.println("11");
//        Water_infos resultW = water_infosService.selectBylocationandfloor(location, floor);
//        String result = "{'bigWater':'" + resultW.getBigWater() + "' , 'smallWater': '" + resultW.getSmallWater() +
//                "'}";
//        return result;
//    }


    @RequestMapping("/getWater_infos")
    public Object getWater_infos(@RequestParam("location")String location){
         System.out.println(location);
         System.out.println(water_infosService.selectBylocation(location));

        List<Water_infos> resultW = water_infosService.selectBylocation(location);
//        String result = "{'bigWater':'" + resultW.getBigWater() + "' , 'smallWater': '" + resultW.getSmallWater() +
//                "'}";
//        System.out.println(resultW);
        return resultW;
    }
}
