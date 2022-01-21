package com.gabrielmbarboza.sienge.rules;

import com.gabrielmbarboza.sienge.exception.NegativeKmException;
import com.gabrielmbarboza.sienge.exception.NegativeWeightCargoException;
import com.gabrielmbarboza.sienge.model.Vehicle;

public interface TransportCalculation {
    Double calculateTotalCost(Vehicle vehicle, int kmTraveled, int weightCargo)
            throws NegativeKmException, NegativeWeightCargoException;

    Double calculateCostKmTraveled(int kmTraveled) throws NegativeKmException;

    Double calculateExcessWeight(int kmTraveled, int weightCargo) throws NegativeWeightCargoException;

    Boolean isExcessWeight(int weightCargo);
}
