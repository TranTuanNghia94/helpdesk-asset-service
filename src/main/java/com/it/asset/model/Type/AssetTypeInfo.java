package com.it.asset.model.Type;

import java.time.Instant;

import lombok.Data;
import java.util.UUID;

@Data
public class AssetTypeInfo {
    private UUID id;
    private String code;
    private String name;
    private String organization;
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
    private Instant createdAt;
    private Instant updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
}
