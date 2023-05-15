package io.mkolodziejczyk92.eventplannerapp.data.service;

import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }
}
