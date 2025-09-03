package com.it.asset.model.Asset;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class AssetHistoryInfo {
    private UUID id;
    private String organization;
    private String asset;
    private String changedBy;
    private String changeType;
    private String fieldName;
    private String oldValue;
    private String newValue;
    private String description;
    private Instant createdAt;
    private Boolean isSystemChange;
}
