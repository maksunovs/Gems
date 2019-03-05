package com.epam.gems.exceptions;

public class ValidationErrorException extends ParserException {
    public ValidationErrorException(String message) {
        super(message);
    }
}
