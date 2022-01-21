package com.gabrielmbarboza.sienge.rules;

import com.gabrielmbarboza.sienge.exception.NegativeKmException;

public interface TruckCalculation {
    Double calculateCost(Double cost) throws NegativeKmException;
}
