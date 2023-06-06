package com.example.springbootrestapidemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:custom.properties")
public class AppConfig {

    @Value("${team.name}")
    private String teamName;
}
