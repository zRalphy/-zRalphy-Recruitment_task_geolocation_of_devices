package com.example.LocalizationRestApi.repository;

import com.example.LocalizationRestApi.model.Geolocation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface GeolocationRepository extends JpaRepository<Geolocation, Long> {
    //deviceId method parameter will be assigned to the query parameter with index 1
    @Query("SELECT l FROM Geolocation l WHERE l.deviceId = ?1")
    Optional<Geolocation> findGeolocationByDeviceId(Integer deviceId);

    //returns active sorted geolocations entities from the database
    @Query("SELECT p FROM Geolocation p")
    List<Geolocation> findAllGeolocations();
}
