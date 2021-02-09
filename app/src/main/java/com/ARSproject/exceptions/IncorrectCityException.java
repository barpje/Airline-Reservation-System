package com.ARSproject.exceptions;

public class IncorrectCityException extends Exception {
    public IncorrectCityException() {
        super("");
    }
    public IncorrectCityException(String errorMessage) {
        super(errorMessage);
    }

}