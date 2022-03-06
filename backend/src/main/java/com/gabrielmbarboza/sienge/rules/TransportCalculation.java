package com.gabrielmbarboza.sienge.rules;

import com.gabrielmbarboza.sienge.model.Vehicle;

public interface TransportCalculation {
    Double calculateTotalCost(Vehicle vehicle, Double kmTraveled, Double weightCargo);

    Double calculateCostKmTraveled(Double kmTraveled);

    Double calculateExcessWeight(Double kmTraveled, Double weightCargo);

    Boolean isExcessWeight(Double weightCargo);
}
