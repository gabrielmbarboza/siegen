package com.gabrielmbarboza.sienge.model;

import com.gabrielmbarboza.sienge.exception.NegativeKmException;

class Truck implements Vehicle {
  private String type;

  public Truck(String type) {
    this.type = type;
  }

  @Override
  public Double calculateTotalCost(Double cost) {
    Double totalCost = 0d;
    try {
      totalCost = TruckType.valueOf(this.type).getTruckCalculation().calculateCost(cost);
    } catch (NegativeKmException e) {
      System.out.println(e.getMessage());
    }
    return totalCost;
  }

  @Override
  public String toString() {
    return type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase() + " " + getClass().getSimpleName();
  }
}
