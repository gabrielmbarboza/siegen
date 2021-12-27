package com.gabrielmbarboza.sienge.calculation;

import com.gabrielmbarboza.sienge.exception.NegativeKmException;
import com.gabrielmbarboza.sienge.exception.NegativeWeightCargoException;
import com.gabrielmbarboza.sienge.model.Vehicle;
import com.gabrielmbarboza.sienge.rules.TransportCalculation;

public class PavedLandCalculation implements TransportCalculation {
    private final int cargoWeightLimit = 5;
    private final Double kmTraveledCost = 0.54;
    private final Double excessWeightCost = 0.02;

    public Double calculateTotalCost(Vehicle vehicle, int kmTraveled, int cargoWeight) {
        Double totalCost = 0.0d;

        try {
            Double costKmTraveled = calculateCostKmTraveled(kmTraveled);
            totalCost = vehicle.calculateTotalCost(costKmTraveled);

            if (cargoWeight < 0)
                totalCost = 0.0d;

            if (isExcessWeight(cargoWeight)) {
                totalCost += (calculateExcessWeight(kmTraveled, cargoWeight));
            }

        } catch (NegativeWeightCargoException | NegativeKmException e) {
            System.out.println(e.getMessage());
        }

        return totalCost;
    }

    public Double calculateCostKmTraveled(int kmTraveled) throws NegativeKmException {
        Double totalKmTraveledCost = 0.0d;

        if (kmTraveled < 0)
            throw new NegativeKmException();

        totalKmTraveledCost = kmTraveledCost * kmTraveled;

        return totalKmTraveledCost;
    }

    public Double calculateExcessWeight(int kmTraveled, int cargoWeight) throws NegativeWeightCargoException {
        int excessWeight = 0;
        Double totalExcessWeightCost = 0.0d;

        if (cargoWeight < 0)
            throw new NegativeWeightCargoException();

        if (cargoWeight > cargoWeightLimit) {
            excessWeight = cargoWeight - cargoWeightLimit;
            totalExcessWeightCost = (excessWeightCost * excessWeight) * kmTraveled;
        }

        return totalExcessWeightCost;
    }

    public Boolean isExcessWeight(int cargoWeight) {
        return cargoWeight > cargoWeightLimit ? true : false;
    }
}
