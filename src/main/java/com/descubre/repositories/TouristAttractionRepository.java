package com.descubre.repositories;

import com.descubre.models.TouristAttraction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TouristAttractionRepository extends MongoRepository <TouristAttraction, String> {
}
