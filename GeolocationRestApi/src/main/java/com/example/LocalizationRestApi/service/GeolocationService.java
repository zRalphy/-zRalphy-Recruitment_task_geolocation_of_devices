package com.example.LocalizationRestApi.service;

import com.example.LocalizationRestApi.model.Geolocation;
import com.example.LocalizationRestApi.repository.GeolocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeolocationService {
    private final GeolocationRepository geolocationRepository;

    @Cacheable("Geolocations")
    public List<Geolocation> getGeolocations() {
        return geolocationRepository.findAllGeolocations();
    }

    @Cacheable("SingleGeolocation")
    public Geolocation getSingleGeolocation(Long geolocationId) {
        return geolocationRepository.findById(geolocationId).orElseThrow();
    }

    public void addNewGeolocation(Geolocation geolocation) {
        Optional<Geolocation> geolocationOptional = geolocationRepository.findGeolocationByDeviceId(geolocation.getDeviceId());
        boolean existsId = geolocationRepository.existsById(geolocation.getId());
        if(geolocationOptional.isPresent()) {
            throw new IllegalStateException("Deviceid exist in database");
        }
        else if(existsId) {
            throw  new IllegalStateException("Geolocation with id " + geolocation.getId() + " exist in database");
        }
        geolocationRepository.save(geolocation);
    }
    @CacheEvict("SingleGeolocation")
    public void deleteGeolocation(Long geolocationId) {
        boolean exists = geolocationRepository.existsById(geolocationId);
        if(!exists) {
            throw new IllegalStateException(
                    " Geolocation with id " + geolocationId + " does not exists ");
        }
        geolocationRepository.deleteById(geolocationId);
    }
}
