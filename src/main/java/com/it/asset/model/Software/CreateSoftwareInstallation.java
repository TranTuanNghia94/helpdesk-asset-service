package com.it.asset.model.Software;

import lombok.Data;
import java.util.UUID;
import java.time.Instant;

@Data
public class CreateSoftwareInstallation {
    private UUID organizationId;
    private UUID licenseId;
    private UUID assetId;
    private UUID userId;
    private Instant installationDate;
    private Instant uninstallationDate;
    private String versionInstalled;
    private String installationPath;
    private Boolean isActive;
    private String notes;
}
