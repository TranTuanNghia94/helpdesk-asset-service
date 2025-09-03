package com.it.asset.model.Asset;

import lombok.Data;
import java.util.UUID;

import java.time.Instant;

@Data
public class CreateAsset {
    private UUID organizationId;
    private String assetTag;
    private String name;
    private String description;
    private UUID assetTypeId;
    private UUID statusId;
    private String manufacturer;
    private String model;
    private String serialNumber;
    private String partNumber;
    private String macAddress;
    private String ipAddress;
    private String hostname;
    private UUID locationId;
    private UUID assignedToId;
    private UUID assignedToDepartmentId;
    private Instant assignedAt;
    private UUID assignedById;
    private UUID vendorId;
    private String purchaseOrderNumber;
    private String invoiceNumber;
    private Instant purchaseDate;
    private Double purchaseCost;
    private Double currentValue;
    private Double depreciationRate;
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
}
