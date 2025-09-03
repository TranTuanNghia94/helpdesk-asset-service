package com.it.asset.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "assets")
public class AssetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "organization_id")
    private UUID organizationId;

    @Column(name = "asset_tag")
    private String assetTag;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "asset_type_id")
    private UUID assetTypeId;

    @Column(name = "status_id")
    private UUID statusId;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "part_number")
    private String partNumber;

    @Column(name = "mac_address")
    private String macAddress;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "hostname")
    private String hostname;

    @Column(name = "location_id")
    private UUID locationId;

    @Column(name = "assigned_to_id")
    private UUID assignedToId;

    @Column(name = "assigned_to_department_id")
    private UUID assignedToDepartmentId;

    @Column(name = "assigned_at")
    private Instant assignedAt;

    @Column(name = "assigned_by_id")
    private UUID assignedById;

    @Column(name = "vendor_id")
    private UUID vendorId;

    @Column(name = "purchase_order_number")
    private String purchaseOrderNumber;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "purchase_date")
    private Instant purchaseDate;

    @Column(name = "purchase_cost")
    private BigDecimal purchaseCost;

    @Column(name = "current_value")
    private BigDecimal currentValue;

    @Column(name = "depreciation_rate")
    private BigDecimal depreciationRate;

    @Column(name = "salvage_value")
    private BigDecimal salvageValue;

    @Column(name = "warranty_start_date")
    private Instant warrantyStartDate;

    @Column(name = "warranty_end_date")
    private Instant warrantyEndDate;

    @Column(name = "warranty_type")
    private String warrantyType;

    @Column(name = "support_contract_number")
    private String supportContractNumber;

    @Column(name = "support_start_date")
    private Instant supportStartDate;

    @Column(name = "support_end_date")
    private Instant supportEndDate;

    @Column(name = "deployment_date")
    private Instant deploymentDate;

    @Column(name = "retirement_date")
    private Instant retirementDate;

    @Column(name = "disposal_date")
    private Instant disposalDate;

    @Column(name = "disposal_method")
    private String disposalMethod;

    @Column(name = "parent_asset_id")
    private UUID parentAssetId;

    @Column(name = "custom_fields", columnDefinition = "JSONB")
    private Object customFields;

    @Column(name = "specifications", columnDefinition = "JSONB")
    private Object specifications;

    @Column(name = "configuration", columnDefinition = "JSONB")
    private Object configuration;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "updated_by")
    private UUID updatedBy;
}
