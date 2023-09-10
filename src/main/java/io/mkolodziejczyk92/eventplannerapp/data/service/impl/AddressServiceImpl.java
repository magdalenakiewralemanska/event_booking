package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.AddressMapper;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.AddressRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.AddressService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public Address saveAddress(AddressDto dto){
        Address newAddress = addressMapper.mapToAddress(dto);
        return addressRepository.save(newAddress);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    public Address updateAddress(AddressDto addressDto) {
        Long id = addressDto.getId();
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity id: " + id + " not found"));

        address.setCity(addressDto.getCity());
        address.setHouseNumber(addressDto.getHouseNumber());
        address.setApartmentNumber(addressDto.getApartmentNumber());
        address.setZipCode(addressDto.getZipCode());
        address.setStreet(addressDto.getStreet());

        return addressRepository.save(address);
    }
}
