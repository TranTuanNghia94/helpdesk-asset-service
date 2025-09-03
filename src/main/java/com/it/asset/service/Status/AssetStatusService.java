package com.it.asset.service.Status;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.it.asset.entity.AssetStatusEntity;
import com.it.asset.mapper.AssetStatusMapper;
import com.it.asset.repository.AssetStatusRepository;
import com.it.asset.model.Status.AssetStatusInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AssetStatusService {
    private final AssetStatusRepository assetStatusRepo;
    private final AssetStatusMapper assetStatusMapper;

    public List<AssetStatusInfo> getAllAssetStatuses() { 
        try {
            log.info("Getting all asset statuses");
            List<AssetStatusEntity> assetStatusEntities = assetStatusRepo.findAll();

            if (assetStatusEntities.isEmpty()) {
                log.info("No asset statuses found");
                return Collections.emptyList();
            }

            List<AssetStatusInfo> assetStatusInfos = assetStatusEntities.stream()
                    .map(assetStatusMapper::toAssetStatusInfo)
                    .collect(Collectors.toList());
            log.info("Asset statuses fetched successfully");
            return assetStatusInfos;
        } catch (Exception e) {
            log.error("Error getting all asset statuses", e);
            throw new RuntimeException("Error getting all asset statuses");
        }
    }
}
