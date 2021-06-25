package com.example.demo;

import com.example.demo.using.entity.User;
import com.example.demo.using.service.UserServiceImpl;
//import org.junit.Before;

import org.junit.Test;
import javax.annotation.Resource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
//@WebAppConfiguration("src/main/resources")
public class DemoApplicationTests {

    @Resource
    private UserServiceImpl userService;

    /*@Before
    public void setUp() {
        // 准备，清空user表
        //userSerivce.deleteAllUsers();
    }*/

    @Test
    public void test() throws Exception{
        //添加用户
        userService.insertUser(new User("aaa","166383","123","河南",523));
        userService.insertUser(new User("bbb","133222","123","tianjin",555));
        userService.insertUser(new User("ccc","123443","123","anhui",543));
    }

}
