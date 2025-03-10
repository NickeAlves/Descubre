package com.descubre.controllers;

import com.descubre.dtos.CityDTO;
import com.descubre.dtos.UpdateCityDTO;
import com.descubre.models.City;
import com.descubre.services.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAllCities() {
        return cityService.findAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable String id) {
        Optional<City> city = cityService.findCityById(id);
        return city
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public City createCity(@RequestBody @Valid CityDTO cityDTO) {
        City city = new City(cityDTO.id(), cityDTO.name(), cityDTO.postalCode(), cityDTO.country(), cityDTO.imageUrl());
        return cityService.saveCity(city);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable String id, @RequestBody @Valid UpdateCityDTO UpdateCityDTO) {
        City updatedCity = cityService.updateCity(id, UpdateCityDTO);
        return ResponseEntity.ok(updatedCity);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}
