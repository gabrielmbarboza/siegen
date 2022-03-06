package com.gabrielmbarboza.sienge.calculation;

import com.gabrielmbarboza.sienge.model.VehicleType;
import com.gabrielmbarboza.sienge.exception.NegativeWeightCargoException;
import com.gabrielmbarboza.sienge.model.Vehicle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UnpavedLandCalculationTest {

  @Test
  public void calculateTotalCost() {
    VehicleType vehicleType = new VehicleType("truck", "box");
    Vehicle vehicle = vehicleType.getVehicle();
    UnpavedLandCalculation unpavedLandCalculation = new UnpavedLandCalculation();
    Double expected = unpavedLandCalculation.calculateTotalCost(vehicle, 1.2, 4d);
    assertThat(expected, is(0.744));
  }

  @Test
  public void calculateExcessWeightWithNegativeWeight() {
    UnpavedLandCalculation unpavedLandCalculation = new UnpavedLandCalculation();
    NegativeWeightCargoException thrown = assertThrows(NegativeWeightCargoException.class,
        () -> unpavedLandCalculation.calculateExcessWeight(1.2, -4d),
        "Expected calculateTotalCost to throw, weight cargo is negative");
    assertThat(thrown.getMessage(), is("The weight of the cargo cannot be negative."));
  }

  @Test
  public void calculateExcessWeightWithoutExccess() {
    UnpavedLandCalculation unpavedLandCalculation = new UnpavedLandCalculation();
    Double expected = unpavedLandCalculation.calculateExcessWeight(1.2, 4d);
    assertThat(expected, is(0.0));
  }

  @Test
  public void calculateExcessWeightWithExccess() {
    UnpavedLandCalculation unpavedLandCalculation = new UnpavedLandCalculation();
    Double expected = unpavedLandCalculation.calculateExcessWeight(1.2, 6d);
    assertThat(expected, is(0.024));
  }
}
