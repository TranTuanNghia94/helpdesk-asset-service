package com.it.asset.model.Software;

import lombok.Data;
import java.time.Instant;
import java.util.UUID;

@Data
public class CreateSoftwareLicense {
    private UUID organizationId;
    private String name;
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
}
