package com.cmar.management.adapter.in.client;

import com.cmar.management.adapter.in.client.dto.CreateClientRequest;
import com.cmar.management.adapter.in.client.dto.CreateClientResponse;
import com.cmar.management.usecase.CreateClientUseCase;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class ClientAdapter {

    private final CreateClientUseCase createClientUseCase;

    public ClientAdapter(CreateClientUseCase createClientUseCase) {
        this.createClientUseCase = createClientUseCase;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateClientResponse> create(@RequestBody CreateClientRequest clientRequest) {
        System.out.println("ASDFASDF" + clientRequest);
        return createClientUseCase.execute(clientRequest);
    }


}
