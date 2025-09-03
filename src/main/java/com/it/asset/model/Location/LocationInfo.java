package com.it.asset.model.Location;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class LocationInfo {
    private UUID id;
    private String name;
    private String organization;
    private String description;
    private String code;
    private String locationType;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String coordinates;
    private String contactPerson;
    private String contactPhone;
    private String contactEmail;
    private String notes;
    private Boolean isActive;
    private Instant createdAt;
    private Instant updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
}
