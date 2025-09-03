-- ====================================
-- HELPDESK SYSTEM - ASSET MANAGEMENT SCHEMA DDL
-- ====================================
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "pg_trgm";
-- ====================================
-- ASSET TYPES
-- ====================================

CREATE TABLE asset_types (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    organization_id UUID NOT NULL REFERENCES organizations(id) ON DELETE CASCADE,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(50) NOT NULL,
    description TEXT,
    category VARCHAR(100), -- Hardware, Software, Service, Infrastructure
    icon VARCHAR(100),
    color VARCHAR(7),
    custom_fields_schema JSONB,
    depreciation_method VARCHAR(50),
    default_depreciation_period_months INTEGER,
    is_trackable BOOLEAN DEFAULT TRUE,
    requires_license BOOLEAN DEFAULT FALSE,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID REFERENCES users(id),
    updated_by UUID REFERENCES users(id),
    UNIQUE(organization_id, code)
);

CREATE INDEX idx_asset_types_organization ON asset_types(organization_id);
CREATE INDEX idx_asset_types_category ON asset_types(category);
CREATE INDEX idx_asset_types_active ON asset_types(is_active);

-- ====================================
-- ASSET STATUSES
-- ====================================

CREATE TABLE asset_statuses (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    organization_id UUID NOT NULL REFERENCES organizations(id) ON DELETE CASCADE,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(50) NOT NULL,
    description TEXT,
    status_type VARCHAR(50) NOT NULL CHECK (status_type IN ('ACTIVE', 'INACTIVE', 'MAINTENANCE', 'RETIRED', 'DISPOSED', 'MISSING', 'DAMAGED')),
    color VARCHAR(7),
    icon VARCHAR(100),
    is_default BOOLEAN DEFAULT FALSE,
    allows_assignment BOOLEAN DEFAULT TRUE,
    sort_order INTEGER DEFAULT 0,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID REFERENCES users(id),
    updated_by UUID REFERENCES users(id),
    UNIQUE(organization_id, code)
);

CREATE INDEX idx_asset_statuses_organization ON asset_statuses(organization_id);
CREATE INDEX idx_asset_statuses_type ON asset_statuses(status_type);

-- ====================================
-- LOCATIONS
-- ====================================

CREATE TABLE locations (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    organization_id UUID NOT NULL REFERENCES organizations(id) ON DELETE CASCADE,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(50) NOT NULL,
    description TEXT,
    parent_location_id UUID REFERENCES locations(id),
    location_type VARCHAR(50) DEFAULT 'OFFICE' CHECK (location_type IN ('OFFICE', 'BUILDING', 'FLOOR', 'ROOM', 'RACK', 'SHELF', 'DESK', 'REMOTE', 'WAREHOUSE')),
    address TEXT,
    city VARCHAR(100),
    state VARCHAR(100),
    country VARCHAR(100),
    postal_code VARCHAR(20),
    coordinates POINT,
    contact_person VARCHAR(255),
    contact_phone VARCHAR(50),
    contact_email VARCHAR(255),
    notes TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID REFERENCES users(id),
    updated_by UUID REFERENCES users(id),
    UNIQUE(organization_id, code)
);

CREATE INDEX idx_locations_organization ON locations(organization_id);
CREATE INDEX idx_locations_parent ON locations(parent_location_id);
CREATE INDEX idx_locations_type ON locations(location_type);
CREATE INDEX idx_locations_active ON locations(is_active);

-- ====================================
-- VENDORS
-- ====================================

CREATE TABLE vendors (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    organization_id UUID NOT NULL REFERENCES organizations(id) ON DELETE CASCADE,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(50) NOT NULL,
    description TEXT,
    vendor_type VARCHAR(50) DEFAULT 'SUPPLIER' CHECK (vendor_type IN ('SUPPLIER', 'MANUFACTURER', 'SERVICE_PROVIDER', 'CONTRACTOR', 'PARTNER')),
    website VARCHAR(500),
    primary_contact_name VARCHAR(255),
    primary_contact_email VARCHAR(255),
    primary_contact_phone VARCHAR(50),
    support_email VARCHAR(255),
    support_phone VARCHAR(50),
    billing_address TEXT,
    shipping_address TEXT,
    tax_id VARCHAR(50),
    payment_terms VARCHAR(100),
    currency VARCHAR(3) DEFAULT 'USD',
    is_preferred BOOLEAN DEFAULT FALSE,
    is_active BOOLEAN DEFAULT TRUE,
    notes TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID REFERENCES users(id),
    updated_by UUID REFERENCES users(id),
    UNIQUE(organization_id, code)
);

CREATE INDEX idx_vendors_organization ON vendors(organization_id);
CREATE INDEX idx_vendors_type ON vendors(vendor_type);
CREATE INDEX idx_vendors_active ON vendors(is_active);

-- ====================================
-- ASSETS
-- ====================================

CREATE TABLE assets (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    organization_id UUID NOT NULL REFERENCES organizations(id) ON DELETE CASCADE,
    asset_tag VARCHAR(100) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    
    -- Classification
    asset_type_id UUID NOT NULL REFERENCES asset_types(id),
    status_id UUID NOT NULL REFERENCES asset_statuses(id),
    
    -- Physical attributes
    manufacturer VARCHAR(255),
    model VARCHAR(255),
    serial_number VARCHAR(255),
    part_number VARCHAR(255),
    mac_address VARCHAR(17),
    ip_address INET,
    hostname VARCHAR(255),
    
    -- Location and assignment
    location_id UUID REFERENCES locations(id),
    assigned_to_id UUID REFERENCES users(id),
    assigned_to_department_id UUID REFERENCES departments(id),
    assigned_at TIMESTAMPTZ,
    assigned_by_id UUID REFERENCES users(id),
    
    -- Vendor and procurement
    vendor_id UUID REFERENCES vendors(id),
    purchase_order_number VARCHAR(100),
    invoice_number VARCHAR(100),
    
    -- Financial information
    purchase_date DATE,
    purchase_cost DECIMAL(12,2),
    current_value DECIMAL(12,2),
    depreciation_rate DECIMAL(5,2),
    salvage_value DECIMAL(12,2),
    
    -- Warranty and support
    warranty_start_date DATE,
    warranty_end_date DATE,
    warranty_type VARCHAR(100),
    support_contract_number VARCHAR(100),
    support_start_date DATE,
    support_end_date DATE,
    
    -- Lifecycle
    deployment_date DATE,
    retirement_date DATE,
    disposal_date DATE,
    disposal_method VARCHAR(100),
    
    -- Parent/Child relationships
    parent_asset_id UUID REFERENCES assets(id),
    
    -- Custom fields and metadata
    custom_fields JSONB,
    specifications JSONB,
    configuration JSONB,
    notes TEXT,
    
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID REFERENCES users(id),
    updated_by UUID REFERENCES users(id)
);

CREATE INDEX idx_assets_organization ON assets(organization_id);
CREATE INDEX idx_assets_tag ON assets(asset_tag);
CREATE INDEX idx_assets_type ON assets(asset_type_id);
CREATE INDEX idx_assets_status ON assets(status_id);
CREATE INDEX idx_assets_location ON assets(location_id);
CREATE INDEX idx_assets_assigned_to ON assets(assigned_to_id);
CREATE INDEX idx_assets_assigned_department ON assets(assigned_to_department_id);
CREATE INDEX idx_assets_vendor ON assets(vendor_id);
CREATE INDEX idx_assets_parent ON assets(parent_asset_id);
CREATE INDEX idx_assets_serial ON assets(serial_number);
CREATE INDEX idx_assets_hostname ON assets(hostname);
CREATE INDEX idx_assets_mac ON assets(mac_address);
CREATE INDEX idx_assets_ip ON assets(ip_address);
CREATE INDEX idx_assets_warranty_end ON assets(warranty_end_date);
CREATE INDEX idx_assets_support_end ON assets(support_end_date);

-- Full text search index
CREATE INDEX idx_assets_search ON assets USING gin(
    to_tsvector('english', name || ' ' || COALESCE(description, '') || ' ' || COALESCE(manufacturer, '') || ' ' || COALESCE(model, ''))
);

-- ====================================
-- ASSET RELATIONSHIPS
-- ====================================

CREATE TABLE asset_relationships (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    source_asset_id UUID NOT NULL REFERENCES assets(id) ON DELETE CASCADE,
    target_asset_id UUID NOT NULL REFERENCES assets(id) ON DELETE CASCADE,
    relationship_type VARCHAR(50) NOT NULL CHECK (relationship_type IN ('CONTAINS', 'CONTAINED_BY', 'CONNECTED_TO', 'DEPENDS_ON', 'SUPPORTS', 'INSTALLED_ON', 'USES', 'REPLACES', 'REPLACED_BY')),
    description TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID REFERENCES users(id),
    UNIQUE(source_asset_id, target_asset_id, relationship_type)
);

CREATE INDEX idx_asset_relationships_source ON asset_relationships(source_asset_id);
CREATE INDEX idx_asset_relationships_target ON asset_relationships(target_asset_id);
CREATE INDEX idx_asset_relationships_type ON asset_relationships(relationship_type);
CREATE INDEX idx_asset_relationships_active ON asset_relationships(is_active);

-- ====================================
-- ASSET HISTORY
-- ====================================

CREATE TABLE asset_history (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    asset_id UUID NOT NULL REFERENCES assets(id) ON DELETE CASCADE,
    changed_by_id UUID REFERENCES users(id),
    change_type VARCHAR(50) NOT NULL,
    field_name VARCHAR(100),
    old_value TEXT,
    new_value TEXT,
    description TEXT,
    is_system_change BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_asset_history_asset ON asset_history(asset_id);
CREATE INDEX idx_asset_history_changed_by ON asset_history(changed_by_id);
CREATE INDEX idx_asset_history_type ON asset_history(change_type);
CREATE INDEX idx_asset_history_created ON asset_history(created_at);

-- ====================================
-- ASSET MAINTENANCE
-- ====================================

CREATE TABLE asset_maintenance (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    asset_id UUID NOT NULL REFERENCES assets(id) ON DELETE CASCADE,
    maintenance_type VARCHAR(50) NOT NULL CHECK (maintenance_type IN ('PREVENTIVE', 'CORRECTIVE', 'PREDICTIVE', 'EMERGENCY', 'UPGRADE', 'INSPECTION')),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    scheduled_date DATE NOT NULL,
    completed_date DATE,
    performed_by_id UUID REFERENCES users(id),
    vendor_id UUID REFERENCES vendors(id),
    cost DECIMAL(10,2),
    duration_hours DECIMAL(5,2),
    status VARCHAR(50) DEFAULT 'SCHEDULED' CHECK (status IN ('SCHEDULED', 'IN_PROGRESS', 'COMPLETED', 'CANCELLED', 'OVERDUE')),
    notes TEXT,
    attachments JSONB,
    next_maintenance_date DATE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID REFERENCES users(id),
    updated_by UUID REFERENCES users(id)
);

CREATE INDEX idx_asset_maintenance_asset ON asset_maintenance(asset_id);
CREATE INDEX idx_asset_maintenance_type ON asset_maintenance(maintenance_type);
CREATE INDEX idx_asset_maintenance_status ON asset_maintenance(status);
CREATE INDEX idx_asset_maintenance_scheduled ON asset_maintenance(scheduled_date);
CREATE INDEX idx_asset_maintenance_performed_by ON asset_maintenance(performed_by_id);

-- ====================================
-- SOFTWARE LICENSES
-- ====================================

CREATE TABLE software_licenses (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    organization_id UUID NOT NULL REFERENCES organizations(id) ON DELETE CASCADE,
    name VARCHAR(255) NOT NULL,
    software_name VARCHAR(255) NOT NULL,
    version VARCHAR(100),
    publisher VARCHAR(255),
    license_type VARCHAR(50) DEFAULT 'COMMERCIAL' CHECK (license_type IN ('COMMERCIAL', 'OPEN_SOURCE', 'FREEWARE', 'SHAREWARE', 'TRIAL', 'SUBSCRIPTION')),
    license_key VARCHAR(1000),
    purchase_date DATE,
    expiration_date DATE,
    seats_total INTEGER NOT NULL DEFAULT 1,
    seats_used INTEGER DEFAULT 0,
    seats_available INTEGER GENERATED ALWAYS AS (seats_total - seats_used) STORED,
    cost_per_seat DECIMAL(10,2),
    total_cost DECIMAL(12,2),
    vendor_id UUID REFERENCES vendors(id),
    support_included BOOLEAN DEFAULT FALSE,
    auto_renewal BOOLEAN DEFAULT FALSE,
    notes TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID REFERENCES users(id),
    updated_by UUID REFERENCES users(id)
);

CREATE INDEX idx_software_licenses_organization ON software_licenses(organization_id);
CREATE INDEX idx_software_licenses_software ON software_licenses(software_name);
CREATE INDEX idx_software_licenses_type ON software_licenses(license_type);
CREATE INDEX idx_software_licenses_expiration ON software_licenses(expiration_date);
CREATE INDEX idx_software_licenses_vendor ON software_licenses(vendor_id);

-- ====================================
-- SOFTWARE INSTALLATIONS
-- ====================================

CREATE TABLE software_installations (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    license_id UUID NOT NULL REFERENCES software_licenses(id) ON DELETE CASCADE,
    asset_id UUID NOT NULL REFERENCES assets(id) ON DELETE CASCADE,
    user_id UUID REFERENCES users(id),
    installation_date DATE NOT NULL,
    uninstallation_date DATE,
    version_installed VARCHAR(100),
    installation_path VARCHAR(500),
    is_active BOOLEAN DEFAULT TRUE,
    notes TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID REFERENCES users(id),
    updated_by UUID REFERENCES users(id),
    UNIQUE(license_id, asset_id, user_id)
);

CREATE INDEX idx_software_installations_license ON software_installations(license_id);
CREATE INDEX idx_software_installations_asset ON software_installations(asset_id);
CREATE INDEX idx_software_installations_user ON software_installations(user_id);
CREATE INDEX idx_software_installations_active ON software_installations(is_active);

-- ====================================
-- UPDATE TRIGGERS
-- ====================================

CREATE TRIGGER update_asset_types_updated_at BEFORE UPDATE ON asset_types FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_asset_statuses_updated_at BEFORE UPDATE ON asset_statuses FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_locations_updated_at BEFORE UPDATE ON locations FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_vendors_updated_at BEFORE UPDATE ON vendors FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_assets_updated_at BEFORE UPDATE ON assets FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_asset_maintenance_updated_at BEFORE UPDATE ON asset_maintenance FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_software_licenses_updated_at BEFORE UPDATE ON software_licenses FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_software_installations_updated_at BEFORE UPDATE ON software_installations FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- ====================================
-- FUNCTIONS FOR ASSET MANAGEMENT
-- ====================================

-- Function to generate asset tag
CREATE OR REPLACE FUNCTION generate_asset_tag()
RETURNS TRIGGER AS $$
DECLARE
    prefix TEXT := 'AST';
    sequence_num INTEGER;
BEGIN
    -- Get next sequence number for the organization
    SELECT COALESCE(MAX(CAST(SUBSTRING(asset_tag FROM '[0-9]+$') AS INTEGER)), 0) + 1
    INTO sequence_num
    FROM assets
    WHERE organization_id = NEW.organization_id;
    
    NEW.asset_tag := prefix || '-' || LPAD(sequence_num::TEXT, 6, '0');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger to auto-generate asset tag
CREATE TRIGGER generate_asset_tag_trigger
    BEFORE INSERT ON assets
    FOR EACH ROW
    WHEN (NEW.asset_tag IS NULL)
    EXECUTE FUNCTION generate_asset_tag();

-- Function to create asset history entries
CREATE OR REPLACE FUNCTION create_asset_history()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO asset_history (asset_id, changed_by_id, change_type, description, is_system_change)
        VALUES (NEW.id, NEW.created_by, 'CREATED', 'Asset created', false);
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        -- Track status changes
        IF OLD.status_id != NEW.status_id THEN
            INSERT INTO asset_history (asset_id, changed_by_id, change_type, field_name, old_value, new_value)
            SELECT NEW.id, NEW.updated_by, 'STATUS_CHANGED', 'status_id', 
                   OLD_STATUS.name, NEW_STATUS.name
            FROM asset_statuses OLD_STATUS, asset_statuses NEW_STATUS
            WHERE OLD_STATUS.id = OLD.status_id AND NEW_STATUS.id = NEW.status_id;
        END IF;
        
        -- Track assignment changes
        IF OLD.assigned_to_id IS DISTINCT FROM NEW.assigned_to_id THEN
            INSERT INTO asset_history (asset_id, changed_by_id, change_type, field_name, old_value, new_value)
            VALUES (NEW.id, NEW.updated_by, 'ASSIGNMENT_CHANGED', 'assigned_to_id', 
                   OLD.assigned_to_id::TEXT, NEW.assigned_to_id::TEXT);
        END IF;
        
        -- Track location changes
        IF OLD.location_id IS DISTINCT FROM NEW.location_id THEN
            INSERT INTO asset_history (asset_id, changed_by_id, change_type, field_name, old_value, new_value)
            SELECT NEW.id, NEW.updated_by, 'LOCATION_CHANGED', 'location_id',
                   OLD_LOCATION.name, NEW_LOCATION.name
            FROM locations OLD_LOCATION, locations NEW_LOCATION
            WHERE OLD_LOCATION.id = OLD.location_id AND NEW_LOCATION.id = NEW.location_id;
        END IF;
        
        RETURN NEW;
    END IF;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

-- Trigger for asset history
CREATE TRIGGER asset_history_trigger
    AFTER INSERT OR UPDATE ON assets
    FOR EACH ROW
    EXECUTE FUNCTION create_asset_history();

-- Function to update software license seat usage
CREATE OR REPLACE FUNCTION update_license_seats()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' AND NEW.is_active = TRUE THEN
        UPDATE software_licenses 
        SET seats_used = seats_used + 1
        WHERE id = NEW.license_id;
    ELSIF TG_OP = 'UPDATE' THEN
        IF OLD.is_active = TRUE AND NEW.is_active = FALSE THEN
            UPDATE software_licenses 
            SET seats_used = seats_used - 1
            WHERE id = NEW.license_id;
        ELSIF OLD.is_active = FALSE AND NEW.is_active = TRUE THEN
            UPDATE software_licenses 
            SET seats_used = seats_used + 1
            WHERE id = NEW.license_id;
        END IF;
    ELSIF TG_OP = 'DELETE' AND OLD.is_active = TRUE THEN
        UPDATE software_licenses 
        SET seats_used = seats_used - 1
        WHERE id = OLD.license_id;
        RETURN OLD;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger to update license seat usage
CREATE TRIGGER update_license_seats_trigger
    AFTER INSERT OR UPDATE OR DELETE ON software_installations
    FOR EACH ROW
    EXECUTE FUNCTION update_license_seats();

-- ====================================
-- INITIAL DATA
-- ====================================

-- Insert default asset types
INSERT INTO asset_types (organization_id, name, code, category, description) VALUES
('00000000-0000-0000-0000-000000000000', 'Desktop Computer', 'DESKTOP', 'Hardware', 'Desktop workstation'),
('00000000-0000-0000-0000-000000000000', 'Laptop Computer', 'LAPTOP', 'Hardware', 'Portable laptop computer'),
('00000000-0000-0000-0000-000000000000', 'Server', 'SERVER', 'Hardware', 'Server hardware'),
('00000000-0000-0000-0000-000000000000', 'Network Switch', 'SWITCH', 'Hardware', 'Network switching equipment'),
('00000000-0000-0000-0000-000000000000', 'Router', 'ROUTER', 'Hardware', 'Network routing equipment'),
('00000000-0000-0000-0000-000000000000', 'Printer', 'PRINTER', 'Hardware', 'Printing device'),
('00000000-0000-0000-0000-000000000000', 'Monitor', 'MONITOR', 'Hardware', 'Display monitor'),
('00000000-0000-0000-0000-000000000000', 'Software License', 'SOFTWARE', 'Software', 'Software application license'),
('00000000-0000-0000-0000-000000000000', 'Mobile Device', 'MOBILE', 'Hardware', 'Smartphone or tablet'),
('00000000-0000-0000-0000-000000000000', 'Virtual Machine', 'VM', 'Infrastructure', 'Virtual machine instance');

-- Insert default asset statuses
INSERT INTO asset_statuses (organization_id, name, code, status_type, allows_assignment, is_default) VALUES
('00000000-0000-0000-0000-000000000000', 'Active', 'ACTIVE', 'ACTIVE', true, true),
('00000000-0000-0000-0000-000000000000', 'Inactive', 'INACTIVE', 'INACTIVE', false, false),
('00000000-0000-0000-0000-000000000000', 'In Maintenance', 'MAINTENANCE', 'MAINTENANCE', false, false),
('00000000-0000-0000-0000-000000000000', 'Retired', 'RETIRED', 'RETIRED', false, false),
('00000000-0000-0000-0000-000000000000', 'Disposed', 'DISPOSED', 'DISPOSED', false, false),
('00000000-0000-0000-0000-000000000000', 'Missing', 'MISSING', 'MISSING', false, false),
('00000000-0000-0000-0000-000000000000', 'Damaged', 'DAMAGED', 'DAMAGED', false, false); 