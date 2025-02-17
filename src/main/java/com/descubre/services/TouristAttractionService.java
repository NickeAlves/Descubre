package com.descubre.services;

import com.descubre.models.TouristAttraction;
import com.descubre.repositories.TouristAttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristAttractionService {

    private final TouristAttractionRepository touristAttractionRepository;

    @Autowired
    public TouristAttractionService(TouristAttractionRepository touristAttractionRepository) {
        this.touristAttractionRepository = touristAttractionRepository;
    }

    public List<TouristAttraction> findAllTouristAttractions() {
        return touristAttractionRepository.findAll();
    }

    public Optional<TouristAttraction> findTouristAttractionById(String id) {
        return touristAttractionRepository.findById(id);
    }

    public TouristAttraction saveTouristAttraction(TouristAttraction touristAttraction) {
        return touristAttractionRepository.save(touristAttraction);
    }

    public void deleteTouristAttraction (String id) {
        touristAttractionRepository.deleteById(id);
    }
}