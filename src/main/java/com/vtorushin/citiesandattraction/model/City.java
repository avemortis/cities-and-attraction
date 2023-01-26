package com.vtorushin.citiesandattraction.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cities", schema = "public")
public class City {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;

    @Column(unique = true)
    private String cityName;
    @Column
    private int population;
    @Column
    private boolean haveMetro;
    @Column
    private String countryName;

    public City() {
    }

    public City(String cityName, int population, String countryName) {
        this.cityName = cityName;
        this.population = population;
        this.countryName = countryName;
        this.haveMetro = false;
    }

    public City(String cityName, int population, boolean haveMetro, String countryName) {
        this.cityName = cityName;
        this.population = population;
        this.haveMetro = haveMetro;
        this.countryName = countryName;
    }

    public Long getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isHaveMetro() {
        return haveMetro;
    }

    public void setHaveMetro(boolean haveMetro) {
        this.haveMetro = haveMetro;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.cityId);
        hash = 79 * hash + Objects.hashCode(this.cityName);
        hash = 79 * hash + this.population;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final City other = (City) obj;
        if (this.population != other.population) {
            return false;
        }
        if (!Objects.equals(this.cityName, other.cityName)) {
            return false;
        }
        return Objects.equals(this.cityId, other.cityId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("id=").append(cityId);
        sb.append(", name='").append(cityName).append('\'');
        sb.append(", population=").append(population);
        sb.append('}');
        return sb.toString();
    }
}