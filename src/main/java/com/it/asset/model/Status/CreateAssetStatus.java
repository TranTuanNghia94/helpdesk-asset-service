package com.it.asset.model.Status;

import lombok.Data;
import java.util.UUID;

@Data
public class CreateAssetStatus {
    private UUID organizationId;
    private String name;
    private String description;
    private String code;
    private String statusType;
    private String color;
    private String icon;
    private Boolean isDefault;
    private Boolean allowsAssignment;
    private Integer sortOrder;
    private String notes;
}
