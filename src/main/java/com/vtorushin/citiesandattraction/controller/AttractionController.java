package com.vtorushin.citiesandattraction.controller;

import com.vtorushin.citiesandattraction.model.Attraction;
import com.vtorushin.citiesandattraction.service.attraction.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttractionController {
    @Autowired
    private AttractionService attractionService;

    @GetMapping("/attractions")
    public List<Attraction> findAttractions() {
        return attractionService.readAll();
    }
}
