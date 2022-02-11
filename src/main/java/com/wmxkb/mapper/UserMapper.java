package com.wmxkb.mapper;

import com.wmxkb.entity.User;
import org.apache.ibatis.annotations.Mapper;

// 让springboot识别为mapper
@Mapper
public interface UserMapper {
    // 方法名要和xml文件id一致
    public User login_check(String username, String password);


}
