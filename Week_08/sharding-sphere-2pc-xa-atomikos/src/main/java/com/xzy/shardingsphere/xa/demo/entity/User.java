package com.xzy.shardingsphere.xa.demo.entity;

public class User {
    private Integer userId;
    private String userName;
    
    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public String getUserName() {
        return userName;
    }
   
}
