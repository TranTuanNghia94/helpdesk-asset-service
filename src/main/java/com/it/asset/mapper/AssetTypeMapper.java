package com.it.asset.mapper;

import org.springframework.stereotype.Component;

import com.it.asset.entity.AssetTypeEntity;
import com.it.asset.model.Type.AssetTypeInfo;

@Component
public class AssetTypeMapper {
    public AssetTypeInfo toAssetTypeInfo(AssetTypeEntity assetTypeEntity) {
        AssetTypeInfo assetTypeInfo = new AssetTypeInfo();
        assetTypeInfo.setId(assetTypeEntity.getId());
        assetTypeInfo.setName(assetTypeEntity.getName());
        assetTypeInfo.setCode(assetTypeEntity.getCode());
        assetTypeInfo.setDescription(assetTypeEntity.getDescription());
        assetTypeInfo.setOrganization(assetTypeEntity.getOrganizationId().toString());
        assetTypeInfo.setCategory(assetTypeEntity.getCategory());
        assetTypeInfo.setIcon(assetTypeEntity.getIcon());
        assetTypeInfo.setColor(assetTypeEntity.getColor());
        assetTypeInfo.setDepreciationMethod(assetTypeEntity.getDepreciationMethod());
        assetTypeInfo.setDepreciationPeriodMonths(assetTypeEntity.getDefaultDepreciationPeriodMonths());
        assetTypeInfo.setIsTrackable(assetTypeEntity.getIsTrackable());
        assetTypeInfo.setRequiresLicense(assetTypeEntity.getRequiresLicense());
        assetTypeInfo.setIsActive(assetTypeEntity.getIsActive());
        assetTypeInfo.setCreatedAt(assetTypeEntity.getCreatedAt());
        assetTypeInfo.setUpdatedAt(assetTypeEntity.getUpdatedAt());
        return assetTypeInfo;
    }

}
