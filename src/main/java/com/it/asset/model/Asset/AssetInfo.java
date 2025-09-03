package com.it.asset.model.Asset;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class AssetInfo {
    private UUID id;
    private String organization;
    private String assetTag;
    private String name;
    private String description;
    private String assetType;

    private String manufacturer;
    private String model;
    private String serialNumber;
    private String partNumber;
    private String macAddress;
    private String ipAddress;
    private String hostname;

    private String status;
    private String location;
    private String assignedTo;
    private String assignedToDepartment;
    private Instant assignedAt;
    private String assignedById;

    private String vendor;
    private String purchaseOrderNumber;
    private String invoiceNumber;
    private Instant purchaseDate;
    private Double purchaseCost;
    private Double currentValue;
    private Double depreciationRate;
    private Double salvageValue;

    private Instant warrantyStartDate;
    private Instant warrantyEndDate;
    private String warrantyType;
    private String supportContractNumber;
    private Instant supportStartDate;
    private Instant supportEndDate;
    private Instant deploymentDate;
    private Instant retirementDate;
    private Instant disposalDate;
    private String disposalMethod;

    private UUID parentAssetId;
    private Object customFields;
    private Object specifications;
    private Object configuration;

    private String notes;
    private Instant createdAt;
    private Instant updatedAt;
    private UUID createdBy;
    private UUID updatedBy;

}
