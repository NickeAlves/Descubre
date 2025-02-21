package com.descubre.controllers;

import com.descubre.dtos.TouristAttractionDTO;
import com.descubre.dtos.UpdateTouristAttractionDTO;
import com.descubre.models.TouristAttraction;
import com.descubre.services.TouristAttractionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attractions")
public class TouristAttractionController {

    private final TouristAttractionService touristAttractionService;

    @Autowired
    public TouristAttractionController(TouristAttractionService touristAttractionService) {
        this.touristAttractionService = touristAttractionService;
    }

    @GetMapping
    public List<TouristAttraction> getAllAttractions() {
        return touristAttractionService.findAllAttractions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TouristAttraction> getAttractionById(@PathVariable String id) {
        Optional<TouristAttraction> attraction = touristAttractionService.findAttractionById(id);
        return attraction
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public TouristAttraction createAttraction(@RequestBody @Valid TouristAttractionDTO attractionDTO) {
        return touristAttractionService.saveAttraction(attractionDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TouristAttraction> updateAttraction(@PathVariable String id, @RequestBody @Valid UpdateTouristAttractionDTO updateTouristAttractionDTO) {
        TouristAttraction updatedAttraction = touristAttractionService.updateAttraction(id, updateTouristAttractionDTO);
        return ResponseEntity.ok(updatedAttraction);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttraction(@PathVariable String id) {
        touristAttractionService.deleteAttraction(id);
        return ResponseEntity.noContent().build();
    }
}
