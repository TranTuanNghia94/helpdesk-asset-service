package com.it.asset.model.Software;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class SoftwareInstallationInfo {
    private UUID id;
    private UUID licenseId;
    private UUID assetId;
    private UUID userId;
    private Instant installationDate;
    private Instant uninstallationDate;
    private String versionInstalled;
    private String installationPath;
    private Boolean isActive;
    private String notes;
    private UUID vendorId;
    private Boolean supportIncluded;
    private Boolean autoRenewal;
    private Instant createdAt;
    private Instant updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
}
