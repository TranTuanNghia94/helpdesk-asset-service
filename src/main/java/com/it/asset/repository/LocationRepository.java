package com.it.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.asset.entity.LocationEntity;
import java.util.UUID;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, UUID> {

    @Query("SELECT l FROM LocationEntity l WHERE l.organizationId = :organizationId")
    List<LocationEntity> findByOrganizationId(@Param("organizationId") UUID organizationId);

}
