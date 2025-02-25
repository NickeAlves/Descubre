package com.descubre.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateCityDTO(String name, String postalCode, String country, String imageUrl) {
}
