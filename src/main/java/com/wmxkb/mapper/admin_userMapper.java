package com.wmxkb.mapper;

import com.wmxkb.entity.admin_user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface admin_userMapper {

    public admin_user checkAdminUser(String userid, String keyword);
}
