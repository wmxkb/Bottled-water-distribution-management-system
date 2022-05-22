package com.wmxkb.entity;

public class message {
    private String username;
    private int isUser;
    private int isAdmin;
    private String messageText;

    public message(){}

    public String getSno() {
        return username;
    }

    public int getIsUser() {
        return isUser;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public String getMessageText() {
        return messageText;
    }
}
