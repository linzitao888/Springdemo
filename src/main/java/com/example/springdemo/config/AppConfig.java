package com.example.springdemo.config;

import com.example.springdemo.entity.User;
import com.example.springdemo.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
 
    @Bean("testUser")
    public User myBean() {
        return new User("测试",18);
    }
 
/*    @Bean
    @Scope("prototype")
    public UserServiceImpl userService(){
        System.out.println("创建UserServiceImpl Bean");
        return new UserServiceImpl();
    }*/

    
}