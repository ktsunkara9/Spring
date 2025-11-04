package com.example.springdemo.restControllers;

import com.example.springdemo.json.Message;
import com.example.springdemo.services.MessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class HelloRestControllerUnitTest {

    @Mock
    private MessageService messageService;

    HelloRestController helloRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        helloRestController = new HelloRestController(messageService);
    }

    @Test
    public void testWelcomeWithDefaultParameter() {
        String expectedMsg = "Hello World!";
        Mockito.when(messageService.getMessage(null)).thenReturn(new Message(expectedMsg));
        ResponseEntity<Message> responseEntity = helloRestController.getMessage(null);
        Assertions.assertEquals(expectedMsg, responseEntity.getBody().getMsg());
    }

    @Test
    public void testWelcomeWithCustomParameter() {
        String expectedMsg = "Hello SKT!";
        Mockito.when(messageService.getMessage("SKT")).thenReturn(new Message(expectedMsg));
        ResponseEntity<Message> responseEntity= helloRestController.getMessage("SKT");
        Assertions.assertEquals(expectedMsg, responseEntity.getBody().getMsg());
    }
}
