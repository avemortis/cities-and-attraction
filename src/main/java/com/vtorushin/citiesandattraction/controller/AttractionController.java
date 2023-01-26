package com.vtorushin.citiesandattraction.controller;

import com.vtorushin.citiesandattraction.model.Attraction;
import com.vtorushin.citiesandattraction.model.AttractionType;
import com.vtorushin.citiesandattraction.model.City;
import com.vtorushin.citiesandattraction.repository.AttractionRepository;
import com.vtorushin.citiesandattraction.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AttractionController {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AttractionRepository attractionRepository;

    @GetMapping("/attractions/{cityName}")
    public List<Attraction> findAttractions(
            @PathVariable(value = "cityName", required = false) String cityName) {

        Optional<City> city = cityRepository.getReferenceByCityName(cityName);
        if (city.isPresent()) {
            return attractionRepository.findByCityId(city.get());
        } else return Collections.emptyList();
    }

    @GetMapping("/attractions")
    public List<Attraction> findAllAttractions(
            @RequestParam Optional<String> attractionType,
            @RequestParam Optional<Boolean> isSorted
    ) {
        List<Attraction> attractions;
        if (attractionType.isPresent())
            attractions = attractionRepository.findByAttractionType(AttractionType.valueOf(attractionType.get()));
        else attractions = attractionRepository.findAll();

        if (isSorted.isPresent() && isSorted.get() && !attractions.isEmpty()) {
            attractions.sort(Comparator.comparing(Attraction::getAttractionName));
        }
        return attractions;
    }

    @PostMapping("/attraction")
    public void create(
            @RequestParam(name = "city") String cityName,
            @RequestParam(name = "name") String attractionName,
            @RequestParam(name = "bdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(name = "desc") String description,
            @RequestParam(name = "type") String type
    ) {
        Optional<City> city = cityRepository.getReferenceByCityName(cityName);
        if (city.isPresent()) {
            Attraction attraction = new Attraction(city.get(), attractionName, date, description, AttractionType.valueOf(type));
            attractionRepository.save(attraction);
        }
    }

    @PutMapping("/attraction/{id}")
    public void edit(
            @PathVariable(value = "id") Long id,
            @RequestParam(name = "desc") String description
    ) {
        Optional<Attraction> attraction = attractionRepository.findById(id);
        if (attraction.isPresent()) {
            attraction.get().setDescription(description);
            attractionRepository.save(attraction.get());
        }
    }

    @DeleteMapping("/attraction/{id}")
    public void delete(
            @PathVariable(value = "id") Long id
    ) {
        Optional<Attraction> attraction = attractionRepository.findById(id);
        attraction.ifPresent(value -> attractionRepository.delete(value));
    }
}
