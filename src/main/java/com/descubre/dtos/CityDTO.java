package com.descubre.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CityDTO(String id,
                      @NotBlank(message = "The name is required.") String name,
                      @NotBlank
                      @Pattern(regexp = "\\d{5}", message = "The postal code must contain exactly 5 digits.") String postalCode,
                      @NotBlank(message = "The country is required.") String country) {
}
