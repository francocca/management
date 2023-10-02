package com.cmar.management.adapter.out.mongodb;

import com.cmar.management.adapter.out.mongodb.entity.ClientEntity;
import com.cmar.management.interfaces.ClientRepository;

import java.util.Optional;

public class ClientRepositoryAdapter implements ClientRepository {
    @Override
    public Optional<ClientEntity> save(ClientEntity clientEntity) {
        System.out.println("Saving client");
        return Optional.of(clientEntity);
    }
}
