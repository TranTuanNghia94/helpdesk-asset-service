package com.it.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.asset.entity.SoftwareInstallationEntity;

import java.util.UUID;
import java.util.List;

@Repository
public interface SoftwareInstalliationRepository extends JpaRepository<SoftwareInstallationEntity, UUID> {

    @Query("SELECT s FROM SoftwareInstallationEntity s WHERE s.organizationId = :organizationId")
    List<SoftwareInstallationEntity> findByOrganizationId(@Param("organizationId") UUID organizationId);

}
