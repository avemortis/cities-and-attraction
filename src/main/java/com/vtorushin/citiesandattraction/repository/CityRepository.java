package com.vtorushin.citiesandattraction.repository;

import com.vtorushin.citiesandattraction.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> getReferenceByCityName(String cityName);
}