package com.gabrielmbarboza.sienge.exception;

public class TruckTypeNotFoundException extends RuntimeException {
  @Override
  public String getMessage() {
    return "Truck type not found.";
  }
}
