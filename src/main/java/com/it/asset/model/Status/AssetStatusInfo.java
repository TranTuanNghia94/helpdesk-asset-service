package com.it.asset.model.Status;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class AssetStatusInfo {
    private UUID id;
    private String name;
    private String organization;
    private String description;
    private String code;
    private String statusType;
    private String color;
    private String icon;
    private Boolean isDefault;
    private Boolean allowsAssignment;
    private String notes;
    private Instant createdAt;
    private Instant updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
}
