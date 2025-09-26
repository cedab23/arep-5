USE buildingdb;

CREATE TABLE building (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(500),
    price DECIMAL(15,2),
    size DOUBLE,
    description TEXT
);

CREATE INDEX idx_building_name ON building(name);
CREATE INDEX idx_building_price ON building(price);