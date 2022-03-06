package com.gabrielmbarboza.sienge.calculation;

import com.gabrielmbarboza.sienge.exception.NegativeKmException;
import com.gabrielmbarboza.sienge.exception.NegativeWeightCargoException;
import com.gabrielmbarboza.sienge.model.Vehicle;
import com.gabrielmbarboza.sienge.rules.TransportCalculation;

public class UnpavedLandCalculation implements TransportCalculation {
    private final Double cargoWeightLimit = 5.0d;
    private final Double kmTraveledCost = 0.62d;
    private final Double excessWeightCost = 0.02d;

    public Double calculateTotalCost(Vehicle vehicle, Double kmTraveled, Double cargoWeight) {
        Double totalCost = 0.0d;
        Double costKmTraveled = calculateCostKmTraveled(kmTraveled);

        totalCost = vehicle.calculateTotalCost(costKmTraveled);

        if (cargoWeight < 0) {
            throw new NegativeWeightCargoException();
        }

        if (isExcessWeight(cargoWeight)) {
            totalCost += (calculateExcessWeight(kmTraveled, cargoWeight));
        }

        return totalCost;
    }

    public Double calculateCostKmTraveled(Double kmTraveled) {
        Double totalKmTraveledCost = 0.0d;

        if (kmTraveled < 0)
            throw new NegativeKmException();

        totalKmTraveledCost = kmTraveledCost * kmTraveled;

        return totalKmTraveledCost;
    }

    public Double calculateExcessWeight(Double kmTraveled, Double cargoWeight) {
        Double excessWeight = 0.0d;
        Double totalExcessWeightCost = 0.0d;

        if (cargoWeight < 0)
            throw new NegativeWeightCargoException();

        if (cargoWeight > cargoWeightLimit) {
            excessWeight = cargoWeight - cargoWeightLimit;
            totalExcessWeightCost = (excessWeightCost * excessWeight) * kmTraveled;
        }

        return totalExcessWeightCost;
    }

    public Boolean isExcessWeight(Double cargoWeight) {
        return cargoWeight > cargoWeightLimit ? true : false;
    }
}
