package com.gabrielmbarboza.sienge.model;

import com.gabrielmbarboza.sienge.exception.NegativeKmException;
import com.gabrielmbarboza.sienge.exception.NegativeWeightCargoException;

class Land implements Transport {
  private String type;

  public Land(String type) {
    this.type = type;
  }

  @Override
  public Double calculateTotalCost(Vehicle vehicle, int kmTraveled, int weightCargo) {
    Double totalCost = 0.0d;

    try {
      totalCost = LandType.valueOf(this.type).getTransportCalculation().calculateTotalCost(vehicle, kmTraveled,
          weightCargo);
    } catch (NegativeKmException | NegativeWeightCargoException e) {
      System.out.println(e.getMessage());
    }

    return totalCost;
  }
}
