package com.it.asset.model.Asset;

import lombok.Data;
import java.util.UUID;

@Data
public class CreateAssetRelationship {
    private UUID organizationId;
    private UUID sourceAssetId;
    private UUID targetAssetId;
    private String relationshipType;
    private String description;
}
