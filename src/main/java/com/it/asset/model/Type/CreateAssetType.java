package com.it.asset.model.Type;

import java.util.UUID;

import lombok.Data; 

@Data
public class CreateAssetType {
    private UUID organizationId;
    private String name;
    private String code;
    private String description;
    private String category;
    private String icon;
    private String color;
    private String depreciationMethod;
    private Integer depreciationPeriodMonths;
    private Boolean isTrackable;
    private Boolean requiresLicense;
    private Boolean isActive;
    private String notes;
}
