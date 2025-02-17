package com.descubre.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "touristAttractions")
public class TouristAttraction {
    @Id
    private String id;
    private String name;

    @DBRef
    private City city;

    private Address address;

    public TouristAttraction() {
    }

    public TouristAttraction(String id, String name, City city, Address address) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "TouristAttraction{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city=" + (city != null ? city.getName() : "Unknown City") +
                ", address=" + address +
                '}';
    }
}
