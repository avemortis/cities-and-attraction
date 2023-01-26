package com.vtorushin.citiesandattraction.controller;

import com.vtorushin.citiesandattraction.model.City;
import com.vtorushin.citiesandattraction.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> findCities() {
        return cityRepository.findAll();
    }

    @PostMapping("/city")
    public void create(
            @RequestParam(name = "name") String cityName,
            @RequestParam(name = "country") String country,
            @RequestParam Optional<Integer> population,
            @RequestParam Optional<Boolean> haveMetro
            ) {
        City city = new City(cityName, 0, country);
        System.out.println(city);
        population.ifPresent(city::setPopulation);
        haveMetro.ifPresent(city::setHaveMetro);
        System.out.println(city);
        cityRepository.save(city);
    }

    @PutMapping("/city/{id}")
    public void edit(
            @PathVariable(value = "id") Long id,
            @RequestParam(name = "population") Optional<Integer> population,
            @RequestParam(name = "haveMetro") Optional<Boolean> haveMetro
    ) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()) {
            haveMetro.ifPresent(value -> city.get().setHaveMetro(value));
            population.ifPresent(value -> city.get().setPopulation(value));
            cityRepository.save(city.get());
        }
    }
}
