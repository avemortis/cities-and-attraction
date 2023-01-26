package com.vtorushin.citiesandattraction.service.city;

import com.vtorushin.citiesandattraction.model.City;

import java.util.List;

public interface CityService {
    void create(City city);
    List<City> readAll();
}
