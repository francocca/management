package com.cmar.management.adapter.out.mongodb.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClientEntity {
    private String name;
    private String phone;
    private String address;
    private String email;
}
