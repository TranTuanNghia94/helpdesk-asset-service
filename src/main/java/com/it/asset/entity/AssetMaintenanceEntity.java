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
@Table(name = "asset_maintenance")
public class AssetMaintenanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "asset_id")
    private UUID assetId;

    @Column(name = "maintenance_type")
    private String maintenanceType;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "scheduled_date")
    private Instant scheduledDate;

    @Column(name = "completed_date")
    private Instant completedDate;

    @Column(name = "performed_by_id")
    private UUID performedById;

    @Column(name = "vendor_id")
    private UUID vendorId;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "duration_hours")
    private BigDecimal durationHours;

    @Column(name = "status")
    private String status;

    @Column(name = "notes")
    private String notes;

    @Column(name = "attachments")
    private String attachments;

    @Column(name = "next_maintenance_date")
    private Instant nextMaintenanceDate;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "updated_by")
    private UUID updatedBy;
}
