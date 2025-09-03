package com.it.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.asset.entity.VendorEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, UUID> {

    @Query("SELECT v FROM VendorEntity v WHERE v.organizationId = :organizationId")
    List<VendorEntity> findByOrganizationId(@Param("organizationId") UUID organizationId);

}
