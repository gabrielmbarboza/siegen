package com.gabrielmbarboza.sienge.calculation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DumpTruckCalculationTest {
  @Test
  public void calculateCostTest() {
    DumpTruckCalculation dumpTruckCalculation = new DumpTruckCalculation();
    Double expected = dumpTruckCalculation.calculateCost(1.5);
    assertThat(expected, is(1.5750000000000002));
  }

  @Test
  public void calculateNegativeCostTest() {
    DumpTruckCalculation dumpTruckCalculation = new DumpTruckCalculation();
    Double expected = dumpTruckCalculation.calculateCost(-1d);
    assertThat(expected, is(0d));
  }

  @Test
  public void calculateCostWithZeroTest() {
    DumpTruckCalculation dumpTruckCalculation = new DumpTruckCalculation();
    Double expected = dumpTruckCalculation.calculateCost(0d);
    assertThat(expected, is(0d));
  }
}
