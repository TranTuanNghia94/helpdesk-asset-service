package com.it.asset.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "asset_types")
public class AssetTypeEntity extends BaseEntity {
    @Column(name = "organization_id")
    private UUID organizationId;

    @Column(name = "category")
    private String category;

    @Column(name = "icon")
    private String icon;

    @Column(name = "color")
    private String color;

    @Column(name = "custom_fields_schema", columnDefinition = "JSONB")
    private Object customFieldsSchema;

    @Column(name = "depreciation_method")
    private String depreciationMethod;

    @Column(name = "default_depreciation_period_months")
    private Integer defaultDepreciationPeriodMonths;

    @Column(name = "is_trackable")
    private Boolean isTrackable;

    @Column(name = "requires_license")
    private Boolean requiresLicense;

    @Column(name = "is_active")
    private Boolean isActive;
}
