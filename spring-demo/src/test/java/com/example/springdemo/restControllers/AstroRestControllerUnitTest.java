package com.example.springdemo.restControllers;

import com.example.springdemo.json.AstroResult;
import com.example.springdemo.json.Astronaut;
import com.example.springdemo.services.AstroService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AstroRestControllerUnitTest {

    @Mock
    private AstroService astroService;

    AstronautRestController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new AstronautRestController(astroService);
    }

    @Test
    public void getAstronautsShouldReturnHTTPStatus200OK() {
        List<Astronaut> astronautList = Arrays.asList(new Astronaut("ISS","Sergey Prokopyev"),
                new Astronaut("ISS","Dmitry Petelin"));
        AstroResult astroResult = new AstroResult("success", 2, astronautList);
        Optional<AstroResult> optionalAstroResult = Optional.of(astroResult);
        Mockito.when(astroService.getAstronauts()).thenReturn(optionalAstroResult);

        ResponseEntity<List<Astronaut>> responseEntity = controller.getAstronauts();
        System.out.println(responseEntity);
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, responseEntity.getBody().size()),
                () -> Assertions.assertTrue(responseEntity.getBody().size() >= 0),
                () -> Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode())
        );
    }
    @Test
    public void getAstronautsShouldReturnHTTPStatus404NotFound() {
        AstroResult astroResult = null;
        Optional<AstroResult> optionalAstroResult = Optional.ofNullable(astroResult);
        Mockito.when(astroService.getAstronauts()).thenReturn(optionalAstroResult);
        ResponseEntity<List<Astronaut>> responseEntity = controller.getAstronauts();
        System.out.println(responseEntity);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

}
