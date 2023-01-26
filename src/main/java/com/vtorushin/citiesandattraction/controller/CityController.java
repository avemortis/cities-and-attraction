package com.vtorushin.citiesandattraction.controller;

import com.vtorushin.citiesandattraction.model.City;
import com.vtorushin.citiesandattraction.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> findCities() {
        return cityService.readAll();
    }

    @PostMapping("/city")
    public void create(City city) {
        cityService.create(city);
    }
}
