package com.udea.empleados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SalaryNotUpdatableException extends RuntimeException {
    public SalaryNotUpdatableException(String message) {
        super(message);
    }
}
