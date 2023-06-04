package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.enums.EAddressType;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.AddressRepository;
import io.mkolodziejczyk92.eventplannerapp.utils.AddressMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;


    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public AddressDto saveAddress(AddressDto addressDto) {
        Address address = addressRepository.save(addressMapper.mapToAddress(addressDto));
        return addressMapper.mapToAddressDto(address);
    }

    public List<AddressDto> getAllOffersAddresses() {
        return addressMapper.mapToAddressDtoList(
                addressRepository.findAddressesByEAddressType(EAddressType.EVENT_ADDRESS));
    }

    public void updateAddressByIdWithoutChangingAddressType(Long id, AddressDto addressDto) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        addressOptional.ifPresentOrElse(address -> {
            address.setStreet(addressDto.getStreet());
            address.setCity(addressDto.getCity());
            address.setHouseNumber(addressDto.getHouseNumber());
            address.setApartmentNumber(addressDto.getApartmentNumber());
            address.setZipCode(addressDto.getZipCode());
            addressRepository.save(address);
        }, () -> {
            throw new EntityNotFoundException("Address id: " + id + " not found");
        });
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}

