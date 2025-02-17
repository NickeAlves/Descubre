package com.descubre.repositories;

import com.descubre.models.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository <City, String> {
}
