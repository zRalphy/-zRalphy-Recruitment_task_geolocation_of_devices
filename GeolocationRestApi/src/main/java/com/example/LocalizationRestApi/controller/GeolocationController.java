package com.example.LocalizationRestApi.controller;

import com.example.LocalizationRestApi.model.Geolocation;
import com.example.LocalizationRestApi.service.GeolocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GeolocationController {

    private final GeolocationService geolocationService;

    @GetMapping("/geolocations")
    public List<Geolocation> getGeolocations() {
        return geolocationService.getGeolocations();
    }

    @GetMapping("/geolocations/{geolocationId}")
    public Geolocation getSingleGeolocation(@PathVariable Long geolocationId) {
        return geolocationService.getSingleGeolocation(geolocationId);
    }

    @PostMapping("/geolocations")
    public void addNewGeolocation(@RequestBody Geolocation geolocation) {
        geolocationService.addNewGeolocation(geolocation);
    }

    @DeleteMapping(path = "/geolocations/{geolocationId}")
    public void deleteGeolocation(@PathVariable("geolocationId") Long geolocationId) {
        geolocationService.deleteGeolocation(geolocationId);
    }
}
