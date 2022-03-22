package com.wmxkb.controller;


import com.wmxkb.entity.commodity_infos;
import com.wmxkb.service.commodity_infosService;
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
public class commodity_InfosController {

    @Autowired
    private commodity_infosService commodityinfosService;

    // 映射请求，GET http://localhost:8080/login
//    @RequestMapping("/getWater_info")
//    public Object getWater_infos(@RequestParam("location")String location, @RequestParam("floor")int floor){
//        // System.out.println("11");
//        Water_infos resultW = commodityinfosService.selectBylocationandfloor(location, floor);
//        String result = "{'bigWater':'" + resultW.getBigWater() + "' , 'smallWater': '" + resultW.getSmallWater() +
//                "'}";
//        return result;
//    }


    @RequestMapping("/getCommodity_infos")
    public Object getWater_infos(@RequestParam("location")String location){
         System.out.println(location);
         System.out.println(commodityinfosService.selectBylocation(location));

        List<Map<String, Object>> resultW = commodityinfosService.selectBylocation(location);
//        String result = "{'bigWater':'" + resultW.getBigWater() + "' , 'smallWater': '" + resultW.getSmallWater() +
//                "'}";
        System.out.println(resultW);
        return resultW;
    }


    @RequestMapping("/reduceCommodityCount")
    public Object reduceCommodityCount(@RequestParam("location")String location, @RequestParam("floor")Integer floor, @RequestParam("commodityType")Integer commodityType){
        int res;
        if(commodityinfosService.selectSingle(location, floor, commodityType) > 0) {
            commodityinfosService.reduceCommodityCount(location, floor, commodityType);
            res = 0;
        }else{
            res = 1;
        }
        return res;
    }

    @RequestMapping("/addCommodityCount")
    public Object addCommodityCount(@RequestParam("location")String location, @RequestParam("floor")Integer floor, @RequestParam("commodityType")Integer commodityType, @RequestParam("Count")Integer Count){
        commodityinfosService.addCommodityCount(location, floor, commodityType, Count);
        return 0;
    }
}
