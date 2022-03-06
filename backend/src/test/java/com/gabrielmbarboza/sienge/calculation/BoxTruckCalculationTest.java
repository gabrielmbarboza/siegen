package com.gabrielmbarboza.sienge.calculation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class BoxTruckCalculationTest {

  @Test
  public void calculateCostTest() {
    BoxTruckCalculation boxTruckCalculation = new BoxTruckCalculation();
    Double expected = boxTruckCalculation.calculateCost(1.5);
    assertThat(expected, is(1.5));
  }

  @Test
  public void calculateNegativeCostTest() {
    BoxTruckCalculation boxTruckCalculation = new BoxTruckCalculation();
    Double expected = boxTruckCalculation.calculateCost(-1d);
    assertThat(expected, is(0d));
  }

  @Test
  public void calculateCostWithZeroTest() {
    BoxTruckCalculation boxTruckCalculation = new BoxTruckCalculation();
    Double expected = boxTruckCalculation.calculateCost(0d);
    assertThat(expected, is(0d));
  }
}