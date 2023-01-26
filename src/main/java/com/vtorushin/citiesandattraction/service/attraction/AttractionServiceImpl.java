package com.vtorushin.citiesandattraction.service.attraction;

import com.vtorushin.citiesandattraction.model.Attraction;
import com.vtorushin.citiesandattraction.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService {

    @Autowired
    private AttractionRepository repository;

    @Override
    public void create(Attraction attraction) {
        repository.save(attraction);
    }

    @Override
    public List<Attraction> readAll() {
        return repository.findAll();
    }

    @Override
    public List<Attraction> findByCity(Long cityId) {
        return null;
    }
}
