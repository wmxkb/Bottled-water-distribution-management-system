package com.wmxkb.mapper;

import com.wmxkb.entity.message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface messageMapper {
    public int addMessage(String username, int isUser, int isAdmin, String messageText);
    public List<message> getMessage(String username);
}
