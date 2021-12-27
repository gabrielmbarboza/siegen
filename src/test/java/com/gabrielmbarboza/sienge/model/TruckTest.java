package com.gabrielmbarboza.sienge.model;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TruckTest {

  @Test
  public void calculateTotalCostBoxTruckTest() {
    Truck truck = new Truck(TruckType.BOX.name());
    assertThat(truck.calculateTotalCost(61.00)).isEqualTo(61.00);
  }

  @Test
  public void calculateTotalCostDumpTruckTest() {
    Truck truck = new Truck(TruckType.DUMP.name());
    assertThat(truck.calculateTotalCost(61.00)).isEqualTo(64.05);
  }

  @Test
  public void calculateTotalCostDumpTractorTest() {
    Truck truck = new Truck(TruckType.TRACTOR.name());
    assertThat(truck.calculateTotalCost(61.00)).isEqualTo(68.32000000000001);
  }

}
