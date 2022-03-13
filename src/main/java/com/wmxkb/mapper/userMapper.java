package com.wmxkb.mapper;

import com.wmxkb.entity.user;
import org.apache.ibatis.annotations.Mapper;

// 让springboot识别为mapper
@Mapper
public interface userMapper {
    // 方法名要和xml文件id一致
    public user login_check(String username, String password);
    public int register(String username, String password, String userid);

}
