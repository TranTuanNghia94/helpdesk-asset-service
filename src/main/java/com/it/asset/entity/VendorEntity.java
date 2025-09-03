package com.it.asset.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vendors")
public class VendorEntity extends BaseEntity {
    @Column(name = "organization_id")
    private UUID organizationId;

    @Column(name = "vendor_type")
    private String vendorType;

    @Column(name = "website")
    private String website;

    @Column(name = "primary_contact_name")
    private String primaryContactName;

    @Column(name = "primary_contact_email")
    private String primaryContactEmail;

    @Column(name = "primary_contact_phone")
    private String primaryContactPhone;

    @Column(name = "support_email")
    private String supportEmail;

    @Column(name = "support_phone")
    private String supportPhone;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "tax_id")
    private String taxId;

    @Column(name = "payment_terms")
    private String paymentTerms;

    @Column(name = "currency")
    private String currency;

    @Column(name = "is_preferred")
    private Boolean isPreferred;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "notes")
    private String notes;
}
