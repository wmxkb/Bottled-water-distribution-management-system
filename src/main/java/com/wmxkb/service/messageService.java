package com.wmxkb.service;

import com.wmxkb.entity.message;
import com.wmxkb.mapper.messageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class messageService {
    @Autowired
    private com.wmxkb.mapper.messageMapper messageMapper;

    public int addMessage(String username, int isUser, int isAdmin, String messageText){
        return messageMapper.addMessage(username, isUser, isAdmin, messageText);
    }

    public List<message> getMessage(String username){
        return messageMapper.getMessage(username);
    }
}
