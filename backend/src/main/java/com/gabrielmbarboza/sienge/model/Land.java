package com.gabrielmbarboza.sienge.model;

class Land implements Transport {
  private String type;

  public Land(String type) {
    this.type = type;
  }

  @Override
  public Double calculateTotalCost(Vehicle vehicle, Double kmTraveled, Double weightCargo) {
    Double totalCost = 0.0d;
    totalCost = LandType.valueOf(this.type).getTransportCalculation().calculateTotalCost(vehicle, kmTraveled,
        weightCargo);

    return totalCost;
  }
}
