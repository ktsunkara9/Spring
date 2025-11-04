package com.example.springdemo.config;

import com.example.springdemo.json.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Message defaultGreeting() {
        return new Message("Hello, World!");
    }

    @Bean
    public Message whatsUpGreeting() {
        return new Message("Hello, Whats up!");
    }
}
