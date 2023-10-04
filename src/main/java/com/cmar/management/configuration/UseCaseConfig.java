package com.cmar.management.configuration;

import com.cmar.management.adapter.out.mongodb.ClientRepositoryAdapter;
import com.cmar.management.interfaces.ClientRepository;
import com.cmar.management.usecase.CreateClientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateClientUseCase createClientUseCase(ClientRepository clientRepository){
        return new CreateClientUseCase(clientRepository);
    }

    @Bean
    public ClientRepository clientRepository(){
        return new ClientRepositoryAdapter();
    }
}
