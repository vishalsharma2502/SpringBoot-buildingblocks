package com.vishal.restservices.exceptions;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 400402007229582624L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
