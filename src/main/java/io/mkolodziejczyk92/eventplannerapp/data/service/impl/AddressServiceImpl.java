package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.service.AddressService;

public class AddressServiceImpl implements AddressService {

    public Address saveAddress(AddressDto dto){
        Address newAddress = new Address();
        newAddress.setStreet(dto.getStreet());
        newAddress.setHouseNumber(dto.getHouseNumber());
        newAddress.setStreet(dto.getStreet());
        newAddress.setZipCode(dto.getZipCode());
        newAddress.setCity(dto.getCity());
        return newAddress;
    }
}
