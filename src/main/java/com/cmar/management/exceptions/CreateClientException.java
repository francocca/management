package com.cmar.management.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CreateClientException extends RuntimeException {

    private final String message;

    private final HttpStatus httpStatus;

    public CreateClientException(String message, HttpStatus status) {
        this.message = message;
        this.httpStatus = status;
    }

}
