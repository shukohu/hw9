package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_MODIFIED)

public class EmployeeStoragesFull extends RuntimeException {
    public EmployeeStoragesFull(String message) {
        super(message);
    }

}
