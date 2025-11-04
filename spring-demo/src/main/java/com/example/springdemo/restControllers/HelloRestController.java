package com.example.springdemo.restControllers;

import com.example.springdemo.json.Message;
import com.example.springdemo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    private MessageService msgService;
    @Autowired
    public HelloRestController(MessageService msgService) {
        this.msgService = msgService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<Message> getMessage(@RequestParam(required = false, defaultValue = "World") String msg) {
        return new ResponseEntity<Message>(msgService.getMessage(msg), HttpStatus.OK);
    }
}
