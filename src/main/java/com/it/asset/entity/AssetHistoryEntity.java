package com.it.asset.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "asset_history")
public class AssetHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "asset_id")
    private UUID assetId;

    @Column(name = "changed_by_id")
    private UUID changedById;

    @Column(name = "change_type")
    private String changeType;

    @Column(name = "field_name")
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

    @Column(name = "description")
    private String description;

    @Column(name = "is_system_change")
    private Boolean isSystemChange;

    @Column(name = "created_at")
    private Instant createdAt;
}
