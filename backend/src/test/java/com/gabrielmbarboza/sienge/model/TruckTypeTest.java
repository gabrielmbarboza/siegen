package com.gabrielmbarboza.sienge.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.gabrielmbarboza.sienge.calculation.BoxTruckCalculation;
import com.gabrielmbarboza.sienge.calculation.DumpTruckCalculation;
import com.gabrielmbarboza.sienge.calculation.TractorTruckCalculation;

@SpringBootTest
public class TruckTypeTest {

  @Test
  public void truckTypeBoxCalculationTest() {
    TruckType truckType = TruckType.BOX;
    assertThat(truckType.getTruckCalculation().getClass(), equalTo(BoxTruckCalculation.class));
  }

  @Test
  public void truckTypeDumpCalculationTest() {
    TruckType truckType = TruckType.DUMP;
    assertThat(truckType.getTruckCalculation().getClass(), equalTo(DumpTruckCalculation.class));
  }

  @Test
  public void truckTypeTractorCalculationTest() {
    TruckType truckType = TruckType.TRACTOR;
    assertThat(truckType.getTruckCalculation().getClass(), equalTo(TractorTruckCalculation.class));
  }
}
