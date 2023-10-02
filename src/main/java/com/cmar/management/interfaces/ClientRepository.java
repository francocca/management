package com.cmar.management.interfaces;

import com.cmar.management.adapter.out.mongodb.entity.ClientEntity;

import java.util.Optional;

public interface ClientRepository {

    Optional<ClientEntity> save(ClientEntity clientEntity);

}
