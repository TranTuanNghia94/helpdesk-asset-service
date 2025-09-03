package com.it.asset.model.Asset;

import lombok.Data;
import java.util.UUID;

@Data
public class CreateAssetHistory {
    private UUID organizationId;
    private UUID assetId;
    private UUID changedById;
    private String changeType;
    private String fieldName;
    private String oldValue;
    private String newValue;
    private String description;
}
