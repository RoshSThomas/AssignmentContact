package com.ContactManagement.System.ContactManagementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Exception extends RuntimeException{

    public Exception(String message){
        super(message = "File Not Found");
    }
}
