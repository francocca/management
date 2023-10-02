package com.cmar.management.interfaces;

import com.cmar.management.adapter.in.client.dto.CreateClientRequest;
import com.cmar.management.adapter.in.client.dto.CreateClientResponse;
import org.springframework.http.ResponseEntity;

public interface UseCase {

    ResponseEntity<CreateClientResponse> execute(CreateClientRequest clientRequest);
}
