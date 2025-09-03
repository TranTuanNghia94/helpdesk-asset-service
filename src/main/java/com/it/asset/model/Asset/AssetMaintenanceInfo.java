package com.it.asset.model.Asset;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class AssetMaintenanceInfo {
    private UUID id;
    private String organization;
    private String asset;
    private String maintenanceType;
    private String title;
    private String description;
    private Instant scheduledDate;
    private Instant completedDate;
    private String performedBy;
    private String vendor;
    private Double cost;
    private Double durationHours;
    private String status;
    private String notes;
    private Object attachments;
    private Instant nextMaintenanceDate;
}
