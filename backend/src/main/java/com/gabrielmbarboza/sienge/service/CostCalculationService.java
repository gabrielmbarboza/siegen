package com.gabrielmbarboza.sienge.service;

import com.gabrielmbarboza.sienge.dto.TransportTotalCost;
import com.gabrielmbarboza.sienge.model.LandType;
import com.gabrielmbarboza.sienge.model.Vehicle;
import com.gabrielmbarboza.sienge.model.VehicleType;
import com.gabrielmbarboza.sienge.rules.TransportCalculation;

import org.springframework.stereotype.Service;

@Service
public class CostCalculationService {
  public TransportTotalCost calculateCost(String vehicleCategory, String vehicleType, Double kmByPavedLand,
      Double kmByUnpavedLand, Double weightCargo) {
    Double totalCost = 0.0d;
    Double pavedLandTotalCost = 0.0d;
    Double unpavedLandTotalCost = 0.0d;
    TransportTotalCost transportTotalCost = null;
    VehicleType _vehicleType = new VehicleType(vehicleCategory, vehicleType);
    Vehicle vehicle = _vehicleType.getVehicle();
    TransportCalculation pavedLand = LandType.PAVED.getTransportCalculation();
    TransportCalculation unpavedLand = LandType.UNPAVED.getTransportCalculation();
    pavedLandTotalCost = pavedLand.calculateTotalCost(vehicle, kmByPavedLand, weightCargo);
    unpavedLandTotalCost = unpavedLand.calculateTotalCost(vehicle, kmByUnpavedLand, weightCargo);
    totalCost = (pavedLandTotalCost + unpavedLandTotalCost);
    transportTotalCost = new TransportTotalCost(vehicle.toString(), pavedLandTotalCost, unpavedLandTotalCost,
        weightCargo,
        totalCost);

    return transportTotalCost;
  }
}
