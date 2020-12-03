package com.xzy.mall.service;

import com.xzy.mall.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserServiceTest {
    
    @Autowired
    private UserService userService;
    
    @Test
    public void insertTest() {
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setUsername("user"+i);
            u.setNickName("昵称_" + i);
            u.setPassword("123");
            u.setStatus(0);
            u.setCreateTime(new Date());
            u.setUpdateTime(new Date());
            userService.insert(u);
        }
    }
}