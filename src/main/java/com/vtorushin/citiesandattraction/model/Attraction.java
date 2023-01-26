package com.vtorushin.citiesandattraction.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "attractions", schema = "public")
public class Attraction {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attractionId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "name", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City city;

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

    public Attraction(Long attractionId, String attractionName, Date buildingDate, String description, AttractionType attractionType, City city) {
        this.attractionId = attractionId;
        this.attractionName = attractionName;
        this.buildingDate = buildingDate;
        this.description = description;
        this.attractionType = attractionType;
        this.city = city;
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

    public Long getAttractionId() {
        return attractionId;
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

    public City getCity() {
        return city;
    }
}
