package com.example.springdemo.services;

import com.example.springdemo.json.Response;
import com.example.springdemo.json.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GeoCoderServiceImpl implements GeoCoderService {

    private final WebClient webClient;
    private static final String baseUrl = "https://maps.googleapis.com";
    private static final String KEY = "AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";

    @Autowired
    public GeoCoderServiceImpl(WebClient.Builder webClientBuilder) {
        webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    @Override
    public Site getLatLang(String... address) {
        String encoded = Stream.of(address)
                .map(s -> URLEncoder.encode(s, StandardCharsets.UTF_8))
                .collect(Collectors.joining(","));
        String path = "/maps/api/geocode/json";
        Response response = webClient.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .queryParam("address", encoded)
                        .queryParam("key", KEY)
                        .build()
                ).retrieve()
                .bodyToMono(Response.class)
                .block(Duration.ofSeconds(2));
        return new Site(response.getFormattedAddress(), response.getLocation().getLat(), response.getLocation().getLng());
    }
}
