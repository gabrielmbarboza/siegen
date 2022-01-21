package com.gabrielmbarboza.sienge.model;

import com.gabrielmbarboza.sienge.calculation.BoxTruckCalculation;
import com.gabrielmbarboza.sienge.calculation.DumpTruckCalculation;
import com.gabrielmbarboza.sienge.calculation.TractorTruckCalculation;
import com.gabrielmbarboza.sienge.rules.TruckCalculation;

public enum TruckType {
    BOX(new BoxTruckCalculation()),
    DUMP(new DumpTruckCalculation()),
    TRACTOR(new TractorTruckCalculation());

    private TruckCalculation truckCalculation;

    TruckType(TruckCalculation truckCalculation) {
        this.truckCalculation = truckCalculation;
    }

    public TruckCalculation getTruckCalculation() {
        return truckCalculation;
    }
}
