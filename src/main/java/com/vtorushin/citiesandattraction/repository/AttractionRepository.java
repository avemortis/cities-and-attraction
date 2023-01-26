package com.vtorushin.citiesandattraction.repository;

import com.vtorushin.citiesandattraction.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
}
