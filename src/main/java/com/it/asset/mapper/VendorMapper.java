package com.it.asset.mapper;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.it.asset.entity.VendorEntity;
import com.it.asset.model.Vendor.CreateVendor;
import com.it.asset.model.Vendor.VendorInfo;

@Component
public class VendorMapper {

    public VendorInfo toVendorInfo(VendorEntity vendorEntity) {
        return VendorInfo.builder()
                .id(vendorEntity.getId())
                .name(vendorEntity.getName())
                .organization(vendorEntity.getOrganizationId().toString())
                .description(vendorEntity.getDescription())
                .code(vendorEntity.getCode())
                .vendorType(vendorEntity.getVendorType())
                .website(vendorEntity.getWebsite())
                .primaryContactName(vendorEntity.getPrimaryContactName())
                .primaryContactEmail(vendorEntity.getPrimaryContactEmail())
                .primaryContactPhone(vendorEntity.getPrimaryContactPhone())
                .supportEmail(vendorEntity.getSupportEmail())
                .supportPhone(vendorEntity.getSupportPhone())
                .billingAddress(vendorEntity.getBillingAddress())
                .shippingAddress(vendorEntity.getShippingAddress())
                .taxId(vendorEntity.getTaxId())
                .paymentTerms(vendorEntity.getPaymentTerms())
                .currency(vendorEntity.getCurrency())
                .isPreferred(vendorEntity.getIsPreferred())
                .isActive(vendorEntity.getIsActive())
                .notes(vendorEntity.getNotes())
                .createdAt(vendorEntity.getCreatedAt())
                .updatedAt(vendorEntity.getUpdatedAt())
                .createdBy(vendorEntity.getCreatedBy())
                .updatedBy(vendorEntity.getUpdatedBy())
                .build();   
    }


    public VendorEntity createVendorEntity(CreateVendor payload) {
        VendorEntity vendorEntity = new VendorEntity();
        vendorEntity.setOrganizationId(payload.getOrganizationId());
        vendorEntity.setName(payload.getName());
        vendorEntity.setCode(payload.getCode());
        vendorEntity.setDescription(payload.getDescription());
        vendorEntity.setVendorType(payload.getVendorType());
        vendorEntity.setWebsite(payload.getWebsite());  
        vendorEntity.setPrimaryContactName(payload.getPrimaryContactName());
        vendorEntity.setPrimaryContactEmail(payload.getPrimaryContactEmail());
        vendorEntity.setPrimaryContactPhone(payload.getPrimaryContactPhone());
        vendorEntity.setSupportEmail(payload.getSupportEmail());
        vendorEntity.setSupportPhone(payload.getSupportPhone());
        vendorEntity.setBillingAddress(payload.getBillingAddress());
        vendorEntity.setShippingAddress(payload.getShippingAddress());
        vendorEntity.setTaxId(payload.getTaxId());
        vendorEntity.setPaymentTerms(payload.getPaymentTerms());
        vendorEntity.setCurrency(payload.getCurrency());
        vendorEntity.setIsPreferred(payload.getIsPreferred());
        vendorEntity.setIsActive(payload.getIsActive());
        vendorEntity.setNotes(payload.getNotes());
        vendorEntity.setCreatedAt(Instant.now());
        vendorEntity.setUpdatedAt(Instant.now());
        vendorEntity.setCreatedBy(payload.getOrganizationId());
        vendorEntity.setUpdatedBy(payload.getOrganizationId());
        vendorEntity.setIsActive(true);
        vendorEntity.setCreatedAt(Instant.now());
        vendorEntity.setUpdatedAt(Instant.now());
        vendorEntity.setCreatedBy(payload.getOrganizationId());
        vendorEntity.setUpdatedBy(payload.getOrganizationId());

        return vendorEntity;
    }
}
