--liquibase formatted sql
-- changeset rmecwaldowski:1
DROP TABLE IF EXISTS GEOLOCATION;
CREATE TABLE GEOLOCATION(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    deviceId INT NOT NULL,
    latitiude INT NOT NULL,
    longitude INT NOT NULL
);