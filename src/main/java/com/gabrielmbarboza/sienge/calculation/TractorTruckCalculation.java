package com.gabrielmbarboza.sienge.calculation;

import com.gabrielmbarboza.sienge.exception.NegativeKmException;
import com.gabrielmbarboza.sienge.rules.TruckCalculation;

public class TractorTruckCalculation implements TruckCalculation {
    private final Double fmc = 1.12;

    @Override
    public Double calculateCost(Double cost) throws NegativeKmException {
        return cost * fmc;
    }
}
