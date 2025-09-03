package com.it.asset.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "locations")
public class LocationEntity extends BaseEntity {
    @Column(name = "parent_location_id")
    private UUID parentLocationId;

    @Column(name = "location_type")
    private String locationType;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "notes")
    private String notes;

    @Column(name = "is_active")
    private Boolean isActive;
}
