package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    Address saveAddress(AddressDto dto);

}
