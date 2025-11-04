package com.example.springdemo.services;

import com.example.springdemo.json.Site;

public interface GeoCoderService {

    Site getLatLang(String... address);
}
