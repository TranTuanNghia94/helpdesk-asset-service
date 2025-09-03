package com.it.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.asset.entity.AssetStatusEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface AssetStatusRepository extends JpaRepository<AssetStatusEntity, UUID> {

    @Query("SELECT a FROM AssetStatusEntity a WHERE a.organizationId = :organizationId")
    List<AssetStatusEntity> findByOrganizationId(@Param("organizationId") UUID organizationId);

}
