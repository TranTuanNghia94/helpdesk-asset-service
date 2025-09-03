package com.it.asset.service.Type;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.it.asset.entity.AssetTypeEntity;
import com.it.asset.mapper.AssetTypeMapper;
import com.it.asset.model.Type.AssetTypeInfo;
import com.it.asset.repository.AssetTypeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AssetTypeService {
    private final AssetTypeRepository assetTypeRepo;
    private final AssetTypeMapper assetTypeMapper;

    public List<AssetTypeInfo> getAllAssetTypes() {
        try {
            log.info("Getting all asset types");
            List<AssetTypeEntity> assetTypeEntities = assetTypeRepo.findAll();
            
            if (assetTypeEntities.isEmpty()) {
                log.info("No asset types found");
                return Collections.emptyList();
            }

            List<AssetTypeInfo> assetTypeInfos = assetTypeEntities.stream()
                    .map(assetTypeMapper::toAssetTypeInfo)
                    .collect(Collectors.toList());
            log.info("Asset types fetched successfully");
            return assetTypeInfos;
        } catch (Exception e) {
            log.error("Error getting all asset types", e);
            throw new RuntimeException("Error getting all asset types");
        }
    }

}
