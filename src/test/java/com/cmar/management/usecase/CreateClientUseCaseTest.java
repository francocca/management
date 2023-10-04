package com.cmar.management.usecase;

import com.cmar.management.adapter.in.client.dto.CreateClientRequest;
import com.cmar.management.adapter.in.client.dto.CreateClientResponse;
import com.cmar.management.adapter.out.mongodb.entity.ClientEntity;
import com.cmar.management.exceptions.CreateClientException;
import com.cmar.management.interfaces.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateClientUseCaseTest {

    @InjectMocks
    CreateClientUseCase testedClass;


    @Mock
    ClientRepository clientRepository;

    @Test
    public void shouldReturnOk() {
        when(clientRepository.save(any())).thenReturn(Optional.of(buildClientEntity()));
        ResponseEntity<CreateClientResponse> response = testedClass.execute(buildCreateClientRequest());
        assertEquals(response.getBody().getName(), "TestName");
    }

    @Test
    public void shouldReturnError() {

        when(clientRepository.save(any())).thenReturn(Optional.empty());
        CreateClientException exception = assertThrows(CreateClientException.class, () -> testedClass.execute(buildCreateClientRequest()));
        assertEquals(exception.getHttpStatus(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ClientEntity buildClientEntity() {
        return ClientEntity.builder()
                .name("TestName")
                .phone("123456")
                .email("email@test.com")
                .address("cra")
                .build();
    }

    public CreateClientRequest buildCreateClientRequest() {
        CreateClientRequest clientRequest = new CreateClientRequest();
        clientRequest.setName("TestName");
        clientRequest.setPhone("123456");
        clientRequest.setEmail("email@test.com");
        clientRequest.setAddress("cra");
        return clientRequest;
    }

}
