package com.cmar.management.adapter.in.client.dto;

import lombok.Builder;

@Builder
public class CreateClientResponse {

    private String name;
    private String phone;
    private String address;
    private String email;
}
