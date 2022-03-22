package com.wmxkb.controller;


import com.alibaba.druid.sql.visitor.functions.Length;
import com.wmxkb.entity.shopping_trolley;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// 扫描映射（Mapper）
@MapperScan("com.wmxkb.mapper")
public class shopping_trolleyController {
    // 注入shopping_trolleyService
    @Autowired
    private com.wmxkb.service.shopping_trolleyService shopping_trolleyService;
    // 映射请求，GET http://localhost:8080/add
    @RequestMapping("/add")
    public Object addItem(@RequestParam("itemInfos[]")String[] itemInfos){
        for(String itemInfo : itemInfos){
            System.out.println(itemInfo);
        }

        shopping_trolley isExist = shopping_trolleyService.selectByMainMessage(itemInfos[0], itemInfos[3], itemInfos[4], Integer.parseInt(itemInfos[5]));


        if(isExist == null){
            shopping_trolleyService.add(itemInfos[0], Double.parseDouble(itemInfos[1]), Integer.parseInt(itemInfos[2]), itemInfos[3], itemInfos[4], Integer.parseInt(itemInfos[5]));
        }else{
            shopping_trolleyService.updateCount(isExist.getCount() + 1, itemInfos[0], itemInfos[3], itemInfos[4], Integer.parseInt(itemInfos[5]));
        }


        return 0;
    }

    @RequestMapping("/reduce")
    public Object reduceCount(@RequestParam("itemInfos[]")String[] itemInfos) {
        if(Integer.parseInt(itemInfos[1]) == 1){
            shopping_trolleyService.deleteItem(itemInfos[0], itemInfos[3], itemInfos[4], Integer.parseInt(itemInfos[5]));
        }else{
            shopping_trolleyService.updateCount( Integer.parseInt(itemInfos[1]) - 1, itemInfos[0], itemInfos[3], itemInfos[4], Integer.parseInt(itemInfos[5]));
        }

        return 0;
    }

    @RequestMapping("/reduceItem")
    public Object reduceItem(@RequestParam("itemInfos[]")String[] itemInfos) {
        shopping_trolleyService.deleteItem(itemInfos[0], itemInfos[3], itemInfos[4], Integer.parseInt(itemInfos[5]));
        return 0;
    }

    @RequestMapping("/reduceSelectItem")
    public Object reduceSelectItem(@RequestParam("orderGoods[]")String[] orderGoods, @RequestParam("orderUserId")String orderUserId, @RequestParam("orderLocation[]")String[] orderLocation, @RequestParam("orderFloor[]")String[] orderFloor){
        int i = 0;
        for(String ordergoods:orderGoods){
            shopping_trolleyService.deleteItem(ordergoods, orderUserId, orderLocation[i], Integer.parseInt(orderFloor[i]));

            i++;
        }
        i = 0;

        return 0;
    }


    @RequestMapping("/getShopping_Trolley")
    public Object getData(@RequestParam("userid")String userid) {
        System.out.println(userid);
        return shopping_trolleyService.selectByUserid(userid);
    }

    @RequestMapping("selectAll")
    public Object selectAll(@RequestParam("userid")String userid){
        List<shopping_trolley> res = shopping_trolleyService.selectByUserid(userid);
        double priceSum = 0;
        for(int i = 0; i < res.size(); i++){
            priceSum += res.get(i).getPrice() * res.get(i).getCount();
        }
        System.out.println(priceSum);
        return priceSum;
    }

    @RequestMapping("deleteAll")
    public Object deleteAll(@RequestParam("userid")String userid){
        int res = shopping_trolleyService.deleteAll(userid);
        return res;
    }

}
