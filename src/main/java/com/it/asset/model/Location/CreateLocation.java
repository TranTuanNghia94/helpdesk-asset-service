package com.it.asset.model.Location;

import java.util.UUID;

import lombok.Data;

@Data   
public class CreateLocation {
    private UUID organizationId;
    private String name;
    private String code;
    private String description;
    private UUID parentLocationId;
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
}
