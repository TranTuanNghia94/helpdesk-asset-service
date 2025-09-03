package com.it.asset.model.Vendor;

import lombok.Data;
import java.util.UUID;

@Data
public class CreateVendor {
    private UUID organizationId;
    private String name;
    private String code;
    private String description;
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
}
