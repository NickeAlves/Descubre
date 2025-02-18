package com.descubre.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cities")
public class City {
    @Id
    private String id;
    @NotBlank(message = "The name is required.")
    private String name;
    @NotBlank
    @Pattern(regexp = "\\d{5}", message = "The postal code must contain exactly 5 digits.")
    private String postalCode;
    @NotBlank(message = "The country is required.")
    private String country;

    public City() {
    }

    public City(String id, String name, String postalCode, String country) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return postalCode + " - " + name + ", " + country;
    }
}
