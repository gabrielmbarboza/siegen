package com.gabrielmbarboza.sienge.exception;

public class NegativeWeightCargoException extends RuntimeException {
    @Override
    public String getMessage() {
        return "The weight of the cargo cannot be negative.";
    }
}
