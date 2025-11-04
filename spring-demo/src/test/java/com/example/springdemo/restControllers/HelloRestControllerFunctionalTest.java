package com.example.springdemo.restControllers;

import com.example.springdemo.json.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerFunctionalTest {

    @LocalServerPort
    private int randomPort;
    private String url;
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setUp() {
        url = "http://localhost:"+randomPort;
        testRestTemplate = new TestRestTemplate();
    }

    @Test
    public void testWelcomeWithDefaultParameter() {
       ResponseEntity<Message> responseEntity = testRestTemplate.getForEntity(url + "/welcome", Message.class);
       Message result = responseEntity.getBody();
       Assertions.assertEquals("Hello World!", result.getMsg());
    }

    @Test
    public void testWelcomeWithCustomParameter() {
        ResponseEntity<Message> responseEntity = testRestTemplate.getForEntity(url+"/welcome?msg=SKT", Message.class);
        Message result = responseEntity.getBody();
        Assertions.assertEquals("Hello SKT!", result.getMsg());
    }
}
