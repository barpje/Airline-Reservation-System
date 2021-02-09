package com.ARSproject.exceptions;

public class IncorrectFlightCodeException extends Exception {
    public IncorrectFlightCodeException() {
        super("");
    }
    public IncorrectFlightCodeException(String errorMessage) {
        super(errorMessage);
    }
}
