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
        User result = userService.login_check(userinfos[0], userinfos[1]);
        // 查询成功（账号密码正确）
        if(result != null){
            System.out.println(userinfos[0] + "login success");
            return 0;
            // 查询失败（null）
        }else{
            System.out.println(userinfos[0] + "login false");
            return 1;
        }
    }

    @RequestMapping("/register")
    public Object login(@RequestParam("username")String username, @RequestParam("password")String password){
        int result = userService.register(username, password);
        // 查询成功（账号密码正确）
        if(result != null){
            System.out.println(userinfos[0] + "register success");
            return 0;
            // 查询失败（null）
        }else{
            System.out.println(userinfos[0] + "register false");
            return 1;
        }
    }
}
