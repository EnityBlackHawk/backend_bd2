package com.example.bd2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class SupplierNotFoundException extends RuntimeException{

    public SupplierNotFoundException(String t)
    {
        super(t);
    }

}
