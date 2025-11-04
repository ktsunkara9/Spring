package com.example.springdemo.services;

import com.example.springdemo.json.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    public Message getMessage(String msg) {
        String message = "Hello "+msg + "!";
        return new Message(message);
    }
}
