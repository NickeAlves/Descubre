package com.descubre.controllers;

import com.descubre.models.TouristAttraction;
import com.descubre.repositories.TouristAttractionRepository;
import com.descubre.security.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist-attractions")
public class TouristAttractionController {
    private final TouristAttractionRepository repository;

    public TouristAttractionController(TouristAttractionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TouristAttraction> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestHeader("Authorization") String token, @RequestBody TouristAttraction attraction) {
        if (!JWTUtil.getRolesFromToken(token.replace("Bearer ", "")).contains("ROLE_ADMIN")) {
            return ResponseEntity.status(403).body("Access denied!");
        }
        repository.save(attraction);
        return ResponseEntity.ok("Attraction created!");
    }
}
