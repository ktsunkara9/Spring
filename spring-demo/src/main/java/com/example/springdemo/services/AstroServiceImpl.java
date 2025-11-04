package com.example.springdemo.services;

import com.example.springdemo.json.AstroResult;
import com.example.springdemo.json.Astronaut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class AstroServiceImpl implements AstroService{

    private RestTemplate restTemplate;
    @Autowired
    public AstroServiceImpl(RestTemplateBuilder rtBuilder) {
        restTemplate = rtBuilder.build();
    }

    @Override
    public Optional<AstroResult> getAstronauts() {
        String url = "http://api.open-notify.org/astros.json";

        ResponseEntity<AstroResult> responseEntity = restTemplate.getForEntity(url, AstroResult.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()) {
            return Optional.ofNullable(responseEntity.getBody());
        } else {
            System.out.println("Failed to get astronauts. Status code: " + responseEntity.getStatusCodeValue());
            return Optional.empty();
        }
    }
}
