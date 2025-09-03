package com.it.asset.model.Asset;

import lombok.Data;
import java.util.UUID;
import java.time.Instant;

@Data
public class CreateAssetMaintenance {
    private UUID organizationId;
    private UUID assetId;
    private String maintenanceType;
    private String title;
    private String description;
    private Instant scheduledDate;
    private Instant completedDate;
    private UUID performedById;
    private UUID vendorId;
    private Double cost;
    private Double durationHours;
    private String status;
    private String notes;
    private Object attachments;
    private Instant nextMaintenanceDate;
}
