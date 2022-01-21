package com.gabrielmbarboza.sienge.exception;

public class NegativeKmException extends Exception {
    @Override
    public String getMessage() {
        return "Mileage cannot be a negative.";
    }
}
