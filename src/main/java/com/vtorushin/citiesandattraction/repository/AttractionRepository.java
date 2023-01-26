package com.vtorushin.citiesandattraction.repository;

import com.vtorushin.citiesandattraction.model.Attraction;
import com.vtorushin.citiesandattraction.model.AttractionType;
import com.vtorushin.citiesandattraction.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    List<Attraction> findByCityId(City city);
    List<Attraction> findByAttractionType(AttractionType attractionType);
}
