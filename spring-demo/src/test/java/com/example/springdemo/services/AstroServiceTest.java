package com.example.springdemo.services;

import com.example.springdemo.json.AstroResult;
import com.example.springdemo.json.Astronaut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AstroServiceTest {

    @Autowired
    private AstroService astroService;

    @Test
    public void getAstronauts() {
        Optional<AstroResult> optionalAstroResult = astroService.getAstronauts();
        if(optionalAstroResult.isPresent()) {
            System.out.println(optionalAstroResult.get());
            AstroResult result = optionalAstroResult.get();
            int numberOfPeople = result.getNumber();
            System.out.println("There are "+numberOfPeople+ " people in Space");
            List<Astronaut> astronauts= result.getPeople();
            astronauts.forEach(System.out::println);
            assertAll(
                    () -> assertTrue(numberOfPeople >= 0),
                    () -> assertEquals(numberOfPeople, astronauts.size())
            );
        }
    }
}
