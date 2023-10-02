package com.cmar.management.adapter.in.client.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateClientRequest {
    private String name;
    private String phone;
    private String address;
    private String email;
}
