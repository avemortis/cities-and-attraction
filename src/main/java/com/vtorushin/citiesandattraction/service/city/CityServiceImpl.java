package com.vtorushin.citiesandattraction.service.city;

import com.vtorushin.citiesandattraction.model.City;
import com.vtorushin.citiesandattraction.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository repository;

    @Override
    public void create(City city) {
        repository.save(city);
    }

    @Override
    public List<City> readAll() {
        return (List<City>) repository.findAll();
    }
}
