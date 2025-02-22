package com.descubre.repositories;

import com.descubre.models.TouristAttraction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristAttractionRepository extends MongoRepository <TouristAttraction, String> {
}
