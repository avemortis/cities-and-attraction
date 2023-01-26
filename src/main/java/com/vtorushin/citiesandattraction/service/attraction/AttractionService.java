package com.vtorushin.citiesandattraction.service.attraction;

import com.vtorushin.citiesandattraction.model.Attraction;
import com.vtorushin.citiesandattraction.model.AttractionType;

import java.util.List;

public interface AttractionService {
    void create(Attraction attraction);
    List<Attraction> readAll();
}
