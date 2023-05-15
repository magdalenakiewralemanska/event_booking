package io.mkolodziejczyk92.eventplannerapp.data.service;

import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }
}
