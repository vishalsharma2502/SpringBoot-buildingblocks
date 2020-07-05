package com.vishal.restservices.exceptions;

public class UserExistsException extends Exception{


    private static final long serialVersionUID = -2844297497031682193L;

    public UserExistsException(String message) {
        super(message);
    }
}
