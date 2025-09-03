package com.it.asset.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "asset_statuses")
public class AssetStatusEntity extends BaseEntity {
    @Column(name = "organization_id")
    private UUID organizationId;

    @Column(name = "status_type")
    private String statusType;

    @Column(name = "color")
    private String color;

    @Column(name = "icon")
    private String icon;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "allows_assignment")
    private Boolean allowsAssignment;

    @Column(name = "sort_order")
    private Integer sortOrder;
}
