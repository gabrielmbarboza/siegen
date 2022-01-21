package com.gabrielmbarboza.sienge.calculation;

import com.gabrielmbarboza.sienge.exception.NegativeKmException;
import com.gabrielmbarboza.sienge.rules.TruckCalculation;

public class BoxTruckCalculation implements TruckCalculation {
    private final Double fmc = 1.00;

    @Override
    public Double calculateCost(Double cost) throws NegativeKmException {
        return cost * fmc;
    }
}
