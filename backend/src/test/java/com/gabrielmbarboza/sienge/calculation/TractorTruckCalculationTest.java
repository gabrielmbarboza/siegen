package com.gabrielmbarboza.sienge.calculation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TractorTruckCalculationTest {
  @Test
  public void calculateCostTest() {
    TractorTruckCalculation tractorTruckCalculation = new TractorTruckCalculation();
    Double expected = tractorTruckCalculation.calculateCost(1.5);
    assertThat(expected, is(1.6800000000000002));
  }

  @Test
  public void calculateNegativeCostTest() {
    TractorTruckCalculation tractorTruckCalculation = new TractorTruckCalculation();
    Double expected = tractorTruckCalculation.calculateCost(-1d);
    assertThat(expected, is(0d));
  }

  @Test
  public void calculateCostWithZeroTest() {
    TractorTruckCalculation tractorTruckCalculation = new TractorTruckCalculation();
    Double expected = tractorTruckCalculation.calculateCost(0d);
    assertThat(expected, is(0d));
  }
}
