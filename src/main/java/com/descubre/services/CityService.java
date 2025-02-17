package com.descubre.services;

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

    public City updateCity(String id, City city) {
        Optional<City> existingCity = cityRepository.findById(id);
        if (existingCity.isPresent()) {
            City updatedCity = existingCity.get();
            updatedCity.setName(city.getName());
            updatedCity.setPostalCode(city.getPostalCode());
            updatedCity.setCountry(city.getCountry());
            return cityRepository.save(updatedCity);
        }
        throw new RuntimeException("City not found");
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }


}
