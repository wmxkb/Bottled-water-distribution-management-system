package com.wmxkb.controller;


import com.wmxkb.entity.commodity_infos;
import com.wmxkb.service.commodity_infosService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
//         System.out.println(location);
//         System.out.println(commodityinfosService.selectBylocation(location));

        List<Map<String, Object>> resultW = commodityinfosService.selectBylocation(location);
//        String result = "{'bigWater':'" + resultW.getBigWater() + "' , 'smallWater': '" + resultW.getSmallWater() +
//                "'}";
//        System.out.println(resultW);
        return resultW;
    }

    @RequestMapping("/showCharts")
    public Object showCharts(@RequestParam("location")String location){
        List<commodity_infos> res = commodityinfosService.showChartsByLocation(location);
        List<int[]> res1 = new ArrayList<>();
        int[] data1 = {0, 0, 0, 0, 0, 0};
        int[] data2 = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i).getCommodityType());
            if(res.get(i).getCommodityType() == 1){
                data1[res.get(i).getFloor() - 1] = res.get(i).getCommodityCount();
            }
            if(res.get(i).getCommodityType() == 2){
                data2[res.get(i).getFloor() - 1] = res.get(i).getCommodityCount();
            }
        }
        res1.add(0, data1);
        res1.add(1, data2);
//        System.out.println(res1);
        return res1;
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
