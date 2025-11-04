package com.example.springdemo.restControllers;

import com.example.springdemo.json.Astronaut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AstroRestControllerFunctionalTest {
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
    public void getAstronauts() {

        ResponseEntity<List<Astronaut>> response =
                testRestTemplate.exchange(url + "/astronauts", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Astronaut>>() {});
        List<Astronaut> astronauts = response.getBody();
        System.out.println(astronauts);
        Assertions.assertEquals(10, astronauts.size());
    }

}
