package com.gabrielmbarboza.sienge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.gabrielmbarboza.sienge.exception.TruckTypeNotFoundException;

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

  @Test
  public void calculateTotalTruckTypeNotExistsTest() {
    // Truck truck = new Truck("tank");
    TruckTypeNotFoundException thrown = assertThrows(TruckTypeNotFoundException.class,
        () -> {
          new Truck("tank");
        },
        "Expected getVehicle to throw, type not found");
    assertThat(thrown.getMessage(), is("Truck type not found."));
  }

  @Test
  public void calculateTotalTruckTypeNullTest() {
    TruckTypeNotFoundException thrown = assertThrows(TruckTypeNotFoundException.class,
        () -> {
          new Truck(null);
        },
        "Expected getVehicle to throw, type not found");
    assertThat(thrown.getMessage(), is("Truck type not found."));
  }

  @Test
  public void calculateTotalTruckTypeEmptyTest() {
    TruckTypeNotFoundException thrown = assertThrows(TruckTypeNotFoundException.class,
        () -> {
          new Truck("");
        },
        "Expected getVehicle to throw, type not found");
    assertThat(thrown.getMessage(), is("Truck type not found."));
  }
}
