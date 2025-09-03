package com.it.asset.entity;

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
@Table(name = "software_installations")
public class SofwareInstallationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "license_id")
    private UUID licenseId;

    @Column(name = "asset_id")
    private UUID assetId;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "installation_date")
    private Instant installationDate;

    @Column(name = "uninstallation_date")
    private Instant uninstallationDate;

    @Column(name = "version_installed")
    private String versionInstalled;

    @Column(name = "installation_path")
    private String installationPath;

    @Column(name = "is_active")
    private Boolean isActive;

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
