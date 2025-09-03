package com.it.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.asset.entity.AssetHistoryEntity;

import java.util.UUID;
import java.util.List;

@Repository
public interface AssetHistoryRepository extends JpaRepository<AssetHistoryEntity, UUID> {

    @Query("SELECT a FROM AssetHistoryEntity a WHERE a.assetId = :assetId")
    List<AssetHistoryEntity> findByAssetId(@Param("assetId") UUID assetId);

    
}
