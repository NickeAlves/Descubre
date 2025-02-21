package com.descubre.dtos;

import com.descubre.models.Address;
import com.descubre.models.City;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateTouristAttractionDTO(String name, City city, Address address) {
}
