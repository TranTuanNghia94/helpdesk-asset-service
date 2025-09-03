package com.it.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.asset.entity.AssetRelationshipEntity;

import java.util.UUID;

import java.util.List;

@Repository
public interface AssetRelationshipRepository extends JpaRepository<AssetRelationshipEntity, UUID> {

    @Query("SELECT a FROM AssetRelationshipEntity a WHERE a.sourceAssetId = :sourceAssetId")
    List<AssetRelationshipEntity> findBySourceAssetId(@Param("sourceAssetId") UUID sourceAssetId);

}
