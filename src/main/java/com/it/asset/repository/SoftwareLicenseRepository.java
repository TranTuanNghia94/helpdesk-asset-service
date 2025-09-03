package com.it.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.asset.entity.SoftwareLicenseEntity;

import java.util.UUID;
import java.util.List;

@Repository
public interface SoftwareLicenseRepository extends JpaRepository<SoftwareLicenseEntity, UUID> {

    @Query("SELECT s FROM SoftwareLicenseEntity s WHERE s.organizationId = :organizationId")
    List<SoftwareLicenseEntity> findByOrganizationId(@Param("organizationId") UUID organizationId);

}
