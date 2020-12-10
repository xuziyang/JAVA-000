package com.xzy.shardingsphere.xa.demo.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    
    @Autowired
    private UserService userService;
    
    @Before
    public void setUp() {
        userService.init();
    }
    
    @After
    public void cleanUp() {
        userService.cleanup();
    }
    
    @Test
    public void testInsert() {
        userService.insert(10);
        assertThat(userService.selectAll(), is(10));
    }
    
    @Test
    public void assertInsertFailed() {
        try {
            userService.insertFailed(10);
            // CHECKSTYLE:OFF
        } catch (final Exception ignore) {
            // CHECKSTYLE:ON
        }
        assertThat(userService.selectAll(), is(0));
    }

}