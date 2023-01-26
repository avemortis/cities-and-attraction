package com.vtorushin.citiesandattraction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "attractions", schema = "public")
public class Attraction {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = City.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private City cityId;

    @Column(unique = true)
    private String attractionName;

    @Column
    private Date buildingDate;

    @Column
    private String description;

    @Column(name = "attr_type")
    @Enumerated(EnumType.STRING)
    private AttractionType attractionType;

    public Attraction() {
    }

    public Attraction(City cityId, String attractionName, Date buildingDate, String description, AttractionType attractionType) {
        this.cityId = cityId;
        this.attractionName = attractionName;
        this.buildingDate = buildingDate;
        this.description = description;
        this.attractionType = attractionType;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Date getBuildingDate() {
        return buildingDate;
    }

    public void setType(AttractionType type) {
        this.attractionType = type;
    }

    public AttractionType getAttractionType() {
        return attractionType;
    }

    public City getCityId() {
        return cityId;
    }
}
