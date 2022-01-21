package com.gabrielmbarboza.sienge.service;

import com.gabrielmbarboza.sienge.dto.TransportTotalCost;
import com.gabrielmbarboza.sienge.exception.NegativeKmException;
import com.gabrielmbarboza.sienge.exception.NegativeWeightCargoException;
import com.gabrielmbarboza.sienge.model.LandType;
import com.gabrielmbarboza.sienge.model.Vehicle;
import com.gabrielmbarboza.sienge.model.VehicleType;
import com.gabrielmbarboza.sienge.rules.TransportCalculation;

import org.springframework.stereotype.Service;

@Service
public class CostCalculationService {
  public TransportTotalCost calculateCost(String vehicleCategory, String vehicleType, int kmByPavedLand,
      int kmByUnpavedLand, int weightCargo) {
    Double totalCost = 0.0d;
    Double pavedLandTotalCost = 0.0d;
    Double unpavedLandTotalCost = 0.0d;
    TransportTotalCost transportTotalCost = null;

    if (isFieldEmpty(vehicleCategory) || isFieldEmpty(vehicleType)) {
      return null;
    }

    try {
      Vehicle vehicle = VehicleType.getVehicle(vehicleCategory, vehicleType);
      System.out.println(vehicle.toString());
      TransportCalculation pavedLand = LandType.PAVED.getTransportCalculation();
      TransportCalculation unpavedLand = LandType.UNPAVED.getTransportCalculation();
      pavedLandTotalCost = pavedLand.calculateTotalCost(vehicle, kmByPavedLand, weightCargo);
      unpavedLandTotalCost = unpavedLand.calculateTotalCost(vehicle, kmByUnpavedLand, weightCargo);
      totalCost = (pavedLandTotalCost + unpavedLandTotalCost);
      transportTotalCost = new TransportTotalCost(vehicle.toString(), kmByPavedLand, kmByUnpavedLand, weightCargo,
          totalCost);
    } catch (NegativeKmException | NegativeWeightCargoException e) {
      e.printStackTrace();
    }

    return transportTotalCost;
  }

  private Boolean isFieldEmpty(String field) {
    return field == null || field.trim().isEmpty();
  }
}
