package com.it.asset.model.Vendor;

import java.time.Instant;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendorInfo {
    private UUID id;
    private String name;
    private String organization;
    private String description;
    private String code;
    private String vendorType;
    private String website;
    private String primaryContactName;
    private String primaryContactEmail;
    private String primaryContactPhone;
    private String supportEmail;
    private String supportPhone;
    private String billingAddress;
    private String shippingAddress;
    private String taxId;
    private String paymentTerms;
    private String currency;
    private Boolean isPreferred;
    private Boolean isActive;
    private String notes;
    private Instant createdAt;
    private Instant updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
}
