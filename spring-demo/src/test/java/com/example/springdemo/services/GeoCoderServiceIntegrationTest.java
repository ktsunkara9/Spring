package com.example.springdemo.services;

import com.example.springdemo.json.Site;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GeoCoderServiceIntegrationTest {

    private static final Logger logger = LoggerFactory.getLogger(GeoCoderServiceIntegrationTest.class);
    @Autowired
    private GeoCoderService service;

    @Test
    public void getLatLngWithoutStreet() {
        Site site = service.getLatLang("Boston", "MA");
        logger.info(site.toString());
        Assertions.assertAll(
                () -> assertEquals(42.36, site.getLat(), 0.01),
                () -> assertEquals(-71.06, site.getLng(), 0.01)
        );
    }

}
