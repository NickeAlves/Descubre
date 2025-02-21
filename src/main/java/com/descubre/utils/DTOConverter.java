package com.descubre.utils;

import com.descubre.dtos.AddressDTO;
import com.descubre.dtos.CityDTO;
import com.descubre.dtos.TouristAttractionDTO;
import com.descubre.models.Address;
import com.descubre.models.City;
import com.descubre.models.TouristAttraction;

public class DTOConverter {

    public static CityDTO convertCityDTO(City city) {
        return new CityDTO(city.getId(), city.getName(), city.getPostalCode(), city.getCountry());
    }

    public static AddressDTO convertAddressDTO(Address address) {
        return new AddressDTO(address.getStreet(), address.getNumber(), address.getNeighborhood(), address.getCity().getId());
    }

    public static TouristAttractionDTO convertTouristAttractionDTO(TouristAttraction touristAttraction) {
        CityDTO cityDTO = convertCityDTO(touristAttraction.getCity());
        AddressDTO addressDTO = convertAddressDTO(touristAttraction.getAddress());
        return new TouristAttractionDTO(touristAttraction.getId(), touristAttraction.getName(), cityDTO, addressDTO);
    }
}
