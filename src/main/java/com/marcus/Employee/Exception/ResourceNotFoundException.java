package com.marcus.Employee.Exception;

public class ResourceNotFoundException extends RuntimeException{
    int status;

    public ResourceNotFoundException(String message, int status){
        super(message);
        this.status = status;
    }
}
