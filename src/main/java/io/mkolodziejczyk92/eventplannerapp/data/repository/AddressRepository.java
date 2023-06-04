package io.mkolodziejczyk92.eventplannerapp.data.repository;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.enums.EAddressType;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAddressesByEAddressType(EAddressType addressType);
    void deleteById(@NotNull Long id);
}
