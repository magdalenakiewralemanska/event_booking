package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import io.mkolodziejczyk92.eventplannerapp.data.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public void createAddress(@RequestBody AddressDto addressDto){
        AddressDto savedAddress = addressService.saveAddress(addressDto);
    }

    @GetMapping
    public List<AddressDto> getAllOffersAddresses(){
        return addressService.getAllOffersAddresses();
    }

    @PutMapping("/{id}")
    public void updateAddressById(@RequestBody AddressDto addressDto, @PathVariable Long id){
        addressService.updateAddressByIdWithoutChangingAddressType(id, addressDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressById(@PathVariable Long id){
        addressService.deleteAddress(id);
    }


}
