package com.it.asset.model.Software;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class SoftwareLicenseInfo {
    private UUID id;
    private String name;
    private String organization;
    private String softwareName;
    private String version;
    private String publisher;
    private String licenseType;
    private String licenseKey;
    private Instant purchaseDate;
    private Instant expirationDate;
    private Integer seatsTotal;
    private Integer seatsUsed;
    private Double costPerSeat;
    private Double totalCost;
    private UUID vendorId;
    private Boolean supportIncluded;
    private Boolean autoRenewal;
    private String notes;
    private Instant createdAt;
    private Instant updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
}
