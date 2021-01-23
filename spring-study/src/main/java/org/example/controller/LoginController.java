package org.example.controller;

import org.example.model.User;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    //后端请求数据校验


    //使用 @Bean 注解
    @Bean
    public User user1(){
        User user = new User();
        user.setUsername("张鹏");
        user.setPassword("123456");
        return user;
    }
    @Bean
    public User user2() {
        User user = new User();
        user.setUsername("胖子");
        user.setPassword("zxc123");
        return user;
    }
}
