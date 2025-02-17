package com.descubre.models;

public class Address {
    private String street;
    private String number;
    private String neighborhood;
    private String cityId;

    public Address() {
    }

    public Address(String street, String number, String neighborhood, String cityId) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.cityId = cityId;
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

    public String cityId() {
        return cityId;
    }

    public void setCityId(String city) {
        this.cityId = cityId;
    }
}
