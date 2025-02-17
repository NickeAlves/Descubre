package com.descubre.repositories;

import com.descubre.models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository <Address, String> {
}
