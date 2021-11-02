package com.revature.Spring.exceptions;

public class ApplicationNotFoundException extends RuntimeException{
    public ApplicationNotFoundException(String message){
        super(message);
    }
}
