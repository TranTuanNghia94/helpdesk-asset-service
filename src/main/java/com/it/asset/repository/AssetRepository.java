package com.it.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.asset.entity.AssetEntity;

import java.util.UUID;
import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<AssetEntity, UUID> {

    @Query("SELECT a FROM AssetEntity a WHERE a.organizationId = :organizationId")
    List<AssetEntity> findByOrganizationId(@Param("organizationId") UUID organizationId);

    
}
