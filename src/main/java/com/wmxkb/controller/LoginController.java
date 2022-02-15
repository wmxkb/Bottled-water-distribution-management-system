package com.wmxkb.controller;
import com.wmxkb.entity.User;
import com.wmxkb.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// 扫描映射（Mapper）
@MapperScan("com.wmxkb.mapper")
public class LoginController {
    // 注入userService
    @Autowired
    private UserService userService;
    // 映射请求，GET http://localhost:8080/login
    @RequestMapping("/login")
    public Object login(@RequestParam("userinfos[]")String[] userinfos){
        for(Object userinfo:userinfos)
            System.out.println(userinfo);
        User result = userService.login_check(userinfos[0], userinfos[1]);
        // 查询成功（账号密码正确）
        if(result != null){
            return 0;
        // 查询失败（null）
        }else{
            return 1;
        }
    }
}
