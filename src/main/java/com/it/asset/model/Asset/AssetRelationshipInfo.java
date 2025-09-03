package com.it.asset.model.Asset;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class AssetRelationshipInfo {
    private UUID id;
    private String organization;
    private String sourceAsset;
    private String targetAsset;
    private String relationshipType;
    private String description;
    private Instant createdAt;
    private String createdBy;
    private Instant updatedAt;
    private String updatedBy;
}