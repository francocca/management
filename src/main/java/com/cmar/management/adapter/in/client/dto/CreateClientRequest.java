package com.cmar.management.adapter.in.client.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateClientRequest {
    private String name;
    private String phone;
    private String address;
    private String email;
}
