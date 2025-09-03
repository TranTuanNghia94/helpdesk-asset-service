package com.it.asset.mapper;

import org.springframework.stereotype.Component;

import com.it.asset.entity.AssetStatusEntity;
import com.it.asset.model.Status.AssetStatusInfo;

@Component
public class AssetStatusMapper {
    public AssetStatusInfo toAssetStatusInfo(AssetStatusEntity assetStatusEntity) {
        AssetStatusInfo assetStatusInfo = new AssetStatusInfo();
        assetStatusInfo.setId(assetStatusEntity.getId());
        assetStatusInfo.setCode(assetStatusEntity.getCode());
        assetStatusInfo.setName(assetStatusEntity.getName());
        assetStatusInfo.setOrganization(assetStatusEntity.getOrganizationId().toString());
        assetStatusInfo.setDescription(assetStatusEntity.getDescription());
        assetStatusInfo.setStatusType(assetStatusEntity.getStatusType());
        assetStatusInfo.setCreatedAt(assetStatusEntity.getCreatedAt());
        assetStatusInfo.setUpdatedAt(assetStatusEntity.getUpdatedAt());
        return assetStatusInfo;
    }

}
