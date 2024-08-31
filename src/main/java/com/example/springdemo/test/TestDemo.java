package com.example.springdemo.test;

import com.example.springdemo.entity.User;
import com.example.springdemo.file.FileUtils;
import com.example.springdemo.service.impl.ExampleService;

import java.util.*;

public class TestDemo {

    public static void main(String[] args) {
        Set<Map<String,String>> set = new HashSet<>();
        Map<String, String> fdzMap = new HashMap<>();
        fdzMap.put("lastName","张三");
        fdzMap.put("workCode","123");

        Map<String, String> fdzMap1 = new HashMap<>();
        fdzMap1.put("lastName","张三");
        fdzMap1.put("workCode","123");

        set.add(fdzMap);
        set.add(fdzMap1);

        System.out.println(set);

    }

}
