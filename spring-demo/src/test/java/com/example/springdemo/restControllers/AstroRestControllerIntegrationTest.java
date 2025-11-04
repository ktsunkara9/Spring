package com.example.springdemo.restControllers;

import com.example.springdemo.json.AstroResult;
import com.example.springdemo.json.Astronaut;
import com.example.springdemo.services.AstroService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AstroRestControllerIntegrationTest {

    @MockBean
    private AstroService astroService;

    @Autowired
    private AstronautRestController controller;

    @Test
    public void getAstronauts() {
        List<Astronaut> astronauts = Arrays.asList(new Astronaut("ISS", "Sergey Prokopyev"),
                new Astronaut("Shenzhou 15", "Zhang Lu"));
        AstroResult astroResult = new AstroResult("success", 2, astronauts);
        Optional<AstroResult> optionalAstroResult = Optional.ofNullable(astroResult);
        Mockito.when(astroService.getAstronauts()).thenReturn(optionalAstroResult);
        ResponseEntity<List<Astronaut>> responseEntity = controller.getAstronauts();
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, responseEntity.getBody().size()),
                () -> Assertions.assertTrue(responseEntity.getBody().size() >= 2)
        );
    }
}
