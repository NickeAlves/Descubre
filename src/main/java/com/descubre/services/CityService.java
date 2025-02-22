package com.descubre.services;

import com.descubre.dtos.UpdateCityDTO;
import com.descubre.models.City;
import com.descubre.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    public Optional<City> findCityById(String id) {
        return cityRepository.findById(id);
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(String id, UpdateCityDTO UpdateCityDTO) {
        City existingCity = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found."));

        if (UpdateCityDTO.name() != null) {
            existingCity.setName(UpdateCityDTO.name());
        }

        if (UpdateCityDTO.postalCode() != null) {
            existingCity.setPostalCode(UpdateCityDTO.postalCode());
        }

        if (UpdateCityDTO.country() != null) {
            existingCity.setCountry(UpdateCityDTO.country());
        }

        return cityRepository.save(existingCity);
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }
}
