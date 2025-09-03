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
@Table(name = "software_licenses")
public class SoftwareLicenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "organization_id")
    private UUID organizationId;

    @Column(name = "name")
    private String name;

    @Column(name = "software_name")
    private String softwareName;

    @Column(name = "version")
    private String version;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "license_type")
    private String licenseType;

    @Column(name = "license_key")
    private String licenseKey;

    @Column(name = "purchase_date")
    private Instant purchaseDate;

    @Column(name = "expiration_date")
    private Instant expirationDate;

    @Column(name = "seats_total")
    private Integer seatsTotal;

    @Column(name = "seats_used")
    private Integer seatsUsed;

    @Column(name = "seats_available")
    private Integer seatsAvailable;

    @Column(name = "cost_per_seat")
    private BigDecimal costPerSeat;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @Column(name = "vendor_id")
    private UUID vendorId;

    @Column(name = "support_included")
    private Boolean supportIncluded;

    @Column(name = "auto_renewal")
    private Boolean autoRenewal;

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
