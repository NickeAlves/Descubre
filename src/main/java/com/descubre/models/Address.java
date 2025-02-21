package com.descubre.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
public class Address {
    @Id
    private String id;
    private String street;
    private String number;
    private String neighborhood;
    private City city;

    public Address() {
    }

    public Address(String street, String number, String neighborhood, City city) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address - " + "\nid: " + id +
                ", street: " + street + ", number: " + number +
                " - neighborhood: " + neighborhood + ", " + city;
    }
}
