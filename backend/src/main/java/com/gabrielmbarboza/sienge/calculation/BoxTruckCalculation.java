package com.gabrielmbarboza.sienge.calculation;

import com.gabrielmbarboza.sienge.rules.TruckCalculation;

public class BoxTruckCalculation implements TruckCalculation {
    private final Double fmc = 1.00d;

    @Override
    public Double calculateCost(Double cost) {
        if (cost < 0d) {
            return 0d;
        }

        return cost * fmc;
    }
}
