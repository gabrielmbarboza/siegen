package com.gabrielmbarboza.sienge.model;

import com.gabrielmbarboza.sienge.calculation.PavedLandCalculation;
import com.gabrielmbarboza.sienge.calculation.UnpavedLandCalculation;
import com.gabrielmbarboza.sienge.rules.TransportCalculation;

public enum LandType {
    PAVED(new PavedLandCalculation()),
    UNPAVED(new UnpavedLandCalculation());

    private TransportCalculation transportCalculation;

    LandType(TransportCalculation transportCalculation) {
        this.transportCalculation = transportCalculation;
    }

    public TransportCalculation getTransportCalculation() {
        return transportCalculation;
    }
}
