package com.example.springdemo.service;

import com.example.springdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    @Qualifier("testUser")
    private User user;
    public void addUser(){
        System.out.println(user.getName());
    }

}
