package com.gabrielmbarboza.sienge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.gabrielmbarboza.sienge.exception.NegativeKmException;
import com.gabrielmbarboza.sienge.exception.NegativeWeightCargoException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LandTest {
  private Double kmTraveled = 10d;
  private Double kmTraveledZero = 0d;
  private Double kmTraveledNegative = -10d;
  private Double weightCargo = 5d;
  private Double weightCargoZero = 0d;
  private Double weightCargoExcess = 6d;
  private Double weightCargoNegative = -5d;

  @Test
  public void calculateTotalPavedLandWithDumpTruckTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(5.670000000000001);
  }

  @Test
  public void calculateTotalPavedLandWithZeroKmTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveledZero, weightCargo)).isEqualTo(0.0);
  }

  @Test
  public void calculateTotalPavedLandWithNegativeKmTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    NegativeKmException thrown = assertThrows(NegativeKmException.class,
        () -> land.calculateTotalCost(vehicle, kmTraveledNegative, weightCargo),
        "Expected calculateTotalCost to throw, km negative");
    assertThat(thrown.getMessage(), equalTo("Mileage cannot be a negative."));
  }

  @Test
  public void calculateTotalUnPavedLandWithZeroKmTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveledZero, weightCargo)).isEqualTo(0.0);
  }

  @Test
  public void calculateTotalUnPavedLandWithNegativeKmTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    NegativeKmException thrown = assertThrows(NegativeKmException.class,
        () -> land.calculateTotalCost(vehicle, kmTraveledNegative, weightCargo),
        "Expected calculateTotalCost to throw, km negative");
    assertThat(thrown.getMessage(), equalTo("Mileage cannot be a negative."));
  }

  @Test
  public void calculateTotalPavedLandWithZeroWeightTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargoZero)).isEqualTo(5.670000000000001);
  }

  @Test
  public void calculateTotalPavedLandWithNegativeWeighTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    NegativeWeightCargoException thrown = assertThrows(NegativeWeightCargoException.class,
        () -> land.calculateTotalCost(vehicle, kmTraveled, weightCargoNegative),
        "Expected calculateTotalCost to throw, weight cargo is negative");
    assertThat(thrown.getMessage(), equalTo("The weight of the cargo cannot be negative."));
  }

  @Test
  public void calculateTotalPavedLandWithDumpTruckAndExcessWeightTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargoExcess)).isEqualTo(5.870000000000001);
  }

  @Test
  public void calculateTotalUnPavedLandWithNegativeWeighTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    NegativeWeightCargoException thrown = assertThrows(NegativeWeightCargoException.class,
        () -> land.calculateTotalCost(vehicle, kmTraveled, weightCargoNegative),
        "Expected calculateTotalCost to throw, weight cargo is negative");
    assertThat(thrown.getMessage(), equalTo("The weight of the cargo cannot be negative."));
  }

  @Test
  public void calculateTotalUnPavedLandWithDumpTruckAndExcessWeightTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargoExcess)).isEqualTo(7.144000000000001);
  }

  @Test
  public void calculateTotalUnpavedLandWithDumpTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(6.510000000000001);
  }

  @Test
  public void calculateTotalUnpavedLandExcessWeightWithDumpTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargoExcess)).isEqualTo(6.710000000000001);
  }

  @Test
  public void calculateTotalPavedLandWithBoxTruckTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(5.4);
  }

  @Test
  public void calculateTotalPavedLandWithBoxTruckAndExcessWeightTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargoExcess)).isEqualTo(5.6000000000000005);
  }

  @Test
  public void calculateTotalUnpavedLandWithBoxTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(6.2);
  }

  @Test
  public void calculateTotalUnpavedLandExcessWeightWithBoxTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargoExcess)).isEqualTo(6.4);
  }

  @Test
  public void calculateTotalPavedLandWithTractorTruckTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(6.048000000000001);
  }

  @Test
  public void calculateTotalPavedLandWithTractorTruckAndExcessWeightTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargoExcess)).isEqualTo(6.248000000000001);
  }

  @Test
  public void calculateTotalUnpavedLandWithTractorTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(6.944000000000001);
  }

  @Test
  public void calculateTotalUnpavedLandExcessWeightWithTractorTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargoExcess)).isEqualTo(7.144000000000001);
  }
}
