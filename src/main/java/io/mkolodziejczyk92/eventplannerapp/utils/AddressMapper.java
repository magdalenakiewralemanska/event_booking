package io.mkolodziejczyk92.eventplannerapp.utils;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto mapToAddressDto(Address address);

    @InheritInverseConfiguration
    Address mapToAddress (AddressDto addressDto);

    List<AddressDto> mapToAddressDtoList(List<Address> addresses);

    @InheritInverseConfiguration
    List<Address> mapToAddressList(List<AddressDto> addressesDto);

}
