package com.example.springdemo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.RequestContextFilter;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/testJersey")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
    }
}