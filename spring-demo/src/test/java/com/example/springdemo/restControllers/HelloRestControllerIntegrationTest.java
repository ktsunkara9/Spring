package com.example.springdemo.restControllers;

import com.example.springdemo.json.Message;
import com.example.springdemo.services.MessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class HelloRestControllerIntegrationTest {

    @MockBean
    private MessageService messageService;

    @Autowired
    private HelloRestController helloRestController;

    @Test
    public void test() {
        Assertions.assertNotNull(messageService);
        Assertions.assertNotNull(helloRestController);
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
        String customMsg = "SKT";
        String expectedMsg = "Hello "+customMsg+"!";
        Mockito.when(messageService.getMessage(customMsg)).thenReturn(new Message(expectedMsg));
        ResponseEntity<Message> responseEntity = helloRestController.getMessage(customMsg);
        Assertions.assertEquals(expectedMsg, responseEntity.getBody().getMsg());
    }
}