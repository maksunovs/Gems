package com.epam.gems.exceptions;

public class ParserException extends Exception {
    private String message;

    public ParserException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
