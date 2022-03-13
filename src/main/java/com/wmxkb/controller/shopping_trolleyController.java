package com.wmxkb.controller;


import com.wmxkb.entity.shopping_trolley;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

        shopping_trolley isExist = shopping_trolleyService.selectBywaterType(itemInfos[0]);


        if(isExist == null){
            shopping_trolleyService.add(itemInfos[0], Double.parseDouble(itemInfos[1]), Integer.parseInt(itemInfos[2]), itemInfos[3]);
        }else{
            shopping_trolleyService.updateCount(isExist.getCount() + 1, itemInfos[0], itemInfos[3]);
        }


        return 0;
    }

    @RequestMapping("/reduce")
    public Object reduceCount(@RequestParam("itemInfos[]")String[] itemInfos) {
        if(Integer.parseInt(itemInfos[1]) == 1){
            shopping_trolleyService.deleteItem(itemInfos[0], itemInfos[3]);
        }else{
            shopping_trolleyService.updateCount( Integer.parseInt(itemInfos[1]) - 1, itemInfos[0], itemInfos[3]);
        }

        return 0;
    }

    @RequestMapping("/reduceItem")
    public Object reduceItem(@RequestParam("itemInfos[]")String[] itemInfos) {
        shopping_trolleyService.deleteItem(itemInfos[0], itemInfos[3]);
        return 0;
    }


    @RequestMapping("/getShopping_Trolley")
    public Object getData(@RequestParam("userid")String userid) {
        return shopping_trolleyService.selectByUserid(userid);
    }
}
