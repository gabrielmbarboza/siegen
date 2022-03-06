package com.gabrielmbarboza.sienge.model;

import com.gabrielmbarboza.sienge.exception.TruckTypeNotFoundException;

public class Truck implements Vehicle {
  private String type;

  public Truck(String type) {
    if (!isTruckTypeExists(type)) {
      throw new TruckTypeNotFoundException();
    }

    this.type = type;
  }

  public Boolean isTruckTypeExists(String type) {
    Boolean truckTypeExists = false;

    if (type == null || type.trim().length() == 0) {
      return false;
    }

    for (TruckType _type : TruckType.values()) {
      if (_type.toString().equalsIgnoreCase(type.toUpperCase())) {
        truckTypeExists = true;
        break;
      }
    }

    return truckTypeExists;
  }

  @Override
  public Double calculateTotalCost(Double cost) {
    Double totalCost = 0.0d;
    totalCost = TruckType.valueOf(this.type).getTruckCalculation().calculateCost(cost);

    return totalCost;
  }

  @Override
  public String toString() {
    return type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase() + " " + getClass().getSimpleName();
  }
}
