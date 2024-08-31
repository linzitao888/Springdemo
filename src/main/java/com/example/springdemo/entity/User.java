package com.example.springdemo.entity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class User {


    private int id;

    private String name;

    private int age;

    public User() {
        System.out.println("创建无参构造器Bean");
    }


    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        System.out.println("创建全参构造器Bean");
    }


    public User(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("创建少参构造器Bean");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
