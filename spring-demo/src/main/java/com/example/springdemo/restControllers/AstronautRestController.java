package com.example.springdemo.restControllers;

import com.example.springdemo.json.AstroResult;
import com.example.springdemo.json.Astronaut;
import com.example.springdemo.services.AstroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AstronautRestController {

    private AstroService astroService;
    @Autowired
    public AstronautRestController(AstroService astroService) {
        this.astroService = astroService;
    }

    @GetMapping("/astronauts")
    public ResponseEntity<List<Astronaut>> getAstronauts() {
        Optional<AstroResult> optionalAstroResult = astroService.getAstronauts();
        if(optionalAstroResult.isPresent()) {
            AstroResult astroResult = optionalAstroResult.get();
            List<Astronaut> astronauts = astroResult.getPeople();
            return ResponseEntity.ok(astronauts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
