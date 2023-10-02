package com.cmar.management.adapter.in.client;

import com.cmar.management.adapter.in.client.dto.CreateClientRequest;
import com.cmar.management.adapter.in.client.dto.CreateClientResponse;
import com.cmar.management.usecase.CreateClientUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class ClientAdapter {

    private final CreateClientUseCase createClientUseCase;

    public ClientAdapter(CreateClientUseCase createClientUseCase) {
        this.createClientUseCase = createClientUseCase;
    }

    public ResponseEntity<CreateClientResponse> create(@RequestBody CreateClientRequest clientRequest) {
        return createClientUseCase.execute(clientRequest);
    }


}
