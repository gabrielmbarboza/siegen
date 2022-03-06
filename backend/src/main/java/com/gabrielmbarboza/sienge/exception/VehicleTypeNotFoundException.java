package com.gabrielmbarboza.sienge.exception;

public class VehicleTypeNotFoundException extends RuntimeException {
  @Override
  public String getMessage() {
    return "Vehicle type not found.";
  }
}
