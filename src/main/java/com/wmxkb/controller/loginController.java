package com.wmxkb.controller;
import com.wmxkb.entity.user;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// 扫描映射（Mapper）
@MapperScan("com.wmxkb.mapper")
public class loginController {
    // 注入userService
    @Autowired
    private com.wmxkb.service.userService userService;
    // 映射请求，GET http://localhost:8080/login
    @RequestMapping("/login")
    public Object login(@RequestParam("userinfos[]")String[] userinfos){
        user result = userService.login_check(userinfos[0], userinfos[1]);
        // 查询成功（账号密码正确）
        if(result != null){
            System.out.println(userinfos[0] + " 登录成功");
            return 0;
            // 查询失败（null）
        }else{
            System.out.println(userinfos[0] + " 登录失败");
            return 1;
        }
    }

    @RequestMapping("/register")
    public Object login(
            @RequestParam("username")String username,
            @RequestParam("password")String password,
            @RequestParam("userid")String userid,
            @RequestParam("name")String name,
            @RequestParam("phone")String phone
    ){
        System.out.println(username + password + userid + name + phone);
        int result;
        try {
            result = userService.register(username, password, userid, name, phone);
            System.out.println(username + "register success");
            result = 0;
        }catch (Exception e){
            result = 1;
            System.out.println(password + "register false");
        }
        return result;
    }

//    @RequestMapping("/searchUser")
//    public Object searchUser(@RequestParam("username")String username){
//        user res = userService.searchUser(username);
//        System.out.println(res);
//        return res;
//    }
    @RequestMapping("/setPassword")
    public Object setPassword(@RequestParam("password")String password, @RequestParam("username")String username){
        System.out.println(password + ' ' + username);
        int res = userService.setPassword(password, username);
        System.out.println(res);
        return res;
    }


}
