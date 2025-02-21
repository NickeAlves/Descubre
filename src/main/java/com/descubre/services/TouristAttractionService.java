package com.descubre.services;

import com.descubre.dtos.TouristAttractionDTO;
import com.descubre.dtos.UpdateTouristAttractionDTO;
import com.descubre.models.TouristAttraction;
import com.descubre.models.City;
import com.descubre.models.Address;
import com.descubre.repositories.TouristAttractionRepository;
import com.descubre.repositories.CityRepository;
import com.descubre.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristAttractionService {

    private final TouristAttractionRepository touristAttractionRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public TouristAttractionService(TouristAttractionRepository touristAttractionRepository,
                                    CityRepository cityRepository,
                                    AddressRepository addressRepository) {
        this.touristAttractionRepository = touristAttractionRepository;
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;
    }

    public List<TouristAttraction> findAllAttractions() {
        return touristAttractionRepository.findAll();
    }

    public Optional<TouristAttraction> findAttractionById(String id) {
        return touristAttractionRepository.findById(id);
    }

    public TouristAttraction saveAttraction(TouristAttractionDTO attractionDTO) {
        City city = cityRepository.findById(attractionDTO.city().id())
                .orElseThrow(() -> new RuntimeException("City not found"));

        Address address = new Address(
                attractionDTO.address().street(),
                attractionDTO.address().number(),
                attractionDTO.address().neighborhood(),
                city
        );

        TouristAttraction attraction = new TouristAttraction(
                null,
                attractionDTO.name(),
                city,
                address
        );

        return touristAttractionRepository.save(attraction);
    }

    public TouristAttraction updateAttraction(String id, UpdateTouristAttractionDTO updateTouristAttractionDTO) {
        TouristAttraction existingAttraction = touristAttractionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tourist Attraction not found"));

        if (updateTouristAttractionDTO.name() != null) {
            existingAttraction.setName(updateTouristAttractionDTO.name());
        }

        if (updateTouristAttractionDTO.city() != null) {
            City city = cityRepository.findById(updateTouristAttractionDTO.city().getId())
                    .orElseThrow(() -> new RuntimeException("City not found"));
            existingAttraction.setCity(city);
        }

        if (updateTouristAttractionDTO.address() != null) {
            Address address = addressRepository.findById(updateTouristAttractionDTO.address().getCity().getId())
                    .orElseThrow(() -> new RuntimeException("Address not found"));
            existingAttraction.setAddress(address);
        }

        return touristAttractionRepository.save(existingAttraction);
    }

    public void deleteAttraction(String id) {
        touristAttractionRepository.deleteById(id);
    }
}
