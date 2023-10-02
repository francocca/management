package com.cmar.management.usecase;

import com.cmar.management.adapter.in.client.dto.CreateClientRequest;
import com.cmar.management.adapter.in.client.dto.CreateClientResponse;
import com.cmar.management.adapter.out.mongodb.entity.ClientEntity;
import com.cmar.management.exceptions.CreateClientException;
import com.cmar.management.interfaces.ClientRepository;
import com.cmar.management.interfaces.UseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CreateClientUseCase implements UseCase {

    private final ClientRepository clientRepository;

    public CreateClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ResponseEntity<CreateClientResponse> execute(CreateClientRequest createClientRequest) {
        System.out.println("Validating request client");
        return clientRepository.save(buildClientEntity(createClientRequest))
                .map(this::buildCreateClientResponse)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new CreateClientException("Error Creating Client", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private ClientEntity buildClientEntity(CreateClientRequest clientRequest){
        return ClientEntity.builder()
                .name(clientRequest.getName())
                .phone(clientRequest.getPhone())
                .address(clientRequest.getAddress())
                .email(clientRequest.getEmail())
                .build();
    }

    private CreateClientResponse buildCreateClientResponse(ClientEntity clientEntity){
        return CreateClientResponse.builder()
                .name(clientEntity.getName())
                .phone(clientEntity.getPhone())
                .address(clientEntity.getAddress())
                .email(clientEntity.getEmail())
                .build();
    }
}
