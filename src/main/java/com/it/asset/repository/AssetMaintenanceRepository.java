package com.it.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.asset.entity.AssetMaintenanceEntity;

import java.util.UUID;
import java.util.List;

@Repository
public interface AssetMaintenanceRepository extends JpaRepository<AssetMaintenanceEntity, UUID> {

    @Query("SELECT a FROM AssetMaintenanceEntity a WHERE a.assetId = :assetId")
    List<AssetMaintenanceEntity> findByAssetId(@Param("assetId") UUID assetId);

}
    
