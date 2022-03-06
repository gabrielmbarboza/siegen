package com.gabrielmbarboza.sienge.exception;

public class VehicleCategoryNotFoundException extends RuntimeException {
  @Override
  public String getMessage() {
    return "Vehicle category not found.";
  }
}