package com.example.springdemo.services;

import com.example.springdemo.json.AstroResult;

import java.util.Optional;

public interface AstroService {

    Optional<AstroResult> getAstronauts();
}
