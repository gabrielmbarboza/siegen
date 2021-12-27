package com.gabrielmbarboza.sienge.model;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LandTest {

  @Test
  public void calculateTotalPavedLandWithDumpTruckTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    int kmTraveled = 10;
    int weightCargo = 5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(5.670000000000001);
  }

  @Test
  public void calculateTotalPavedLandWithZeroKmTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    int kmTraveled = 0;
    int weightCargo = 5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(0.0);
  }

  @Test
  public void calculateTotalPavedLandWithNegativeKmTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    int kmTraveled = -10;
    int weightCargo = 5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(0.0);
  }

  @Test
  public void calculateTotalUnPavedLandWithZeroKmTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    int kmTraveled = 0;
    int weightCargo = 5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(0.0);
  }

  @Test
  public void calculateTotalUnPavedLandWithNegativeKmTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    int kmTraveled = -10;
    int weightCargo = 5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(0.0);
  }

  @Test
  public void calculateTotalPavedLandWithZeroWeightTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    int kmTraveled = 10;
    int weightCargo = 0;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(5.670000000000001);
  }

  @Test
  public void calculateTotalPavedLandWithNegativeWeighTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    int kmTraveled = 10;
    int weightCargo = -5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(0.0);
  }

  @Test
  public void calculateTotalPavedLandWithDumpTruckAndExcessWeightTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    int kmTraveled = 10;
    int weightCargo = 6;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(5.870000000000001);
  }

  @Test
  public void calculateTotalUnPavedLandWithNegativeWeighTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    int kmTraveled = 10;
    int weightCargo = -5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(0.0);
  }

  @Test
  public void calculateTotalUnPavedLandWithDumpTruckAndExcessWeightTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    int kmTraveled = 10;
    int weightCargo = 6;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(7.144000000000001);
  }

  @Test
  public void calculateTotalUnpavedLandWithDumpTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    int kmTraveled = 10;
    int weightCargo = 5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(6.510000000000001);
  }

  @Test
  public void calculateTotalUnpavedLandExcessWeightWithDumpTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.DUMP.name());
    int kmTraveled = 10;
    int weightCargo = 6;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(6.710000000000001);
  }

  @Test
  public void calculateTotalPavedLandWithBoxTruckTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    int kmTraveled = 10;
    int weightCargo = 5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(5.4);
  }

  @Test
  public void calculateTotalPavedLandWithBoxTruckAndExcessWeightTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    int kmTraveled = 10;
    int weightCargo = 6;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(5.6000000000000005);
  }

  @Test
  public void calculateTotalUnpavedLandWithBoxTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    int kmTraveled = 10;
    int weightCargo = 5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(6.2);
  }

  @Test
  public void calculateTotalUnpavedLandExcessWeightWithBoxTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.BOX.name());
    int kmTraveled = 10;
    int weightCargo = 6;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(6.4);
  }

  @Test
  public void calculateTotalPavedLandWithTractorTruckTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    int kmTraveled = 10;
    int weightCargo = 5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(6.048000000000001);
  }

  @Test
  public void calculateTotalPavedLandWithTractorTruckAndExcessWeightTest() {
    Land land = new Land(LandType.PAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    int kmTraveled = 10;
    int weightCargo = 6;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(6.248000000000001);
  }

  @Test
  public void calculateTotalUnpavedLandWithTractorTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    int kmTraveled = 10;
    int weightCargo = 5;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(6.944000000000001);
  }

  @Test
  public void calculateTotalUnpavedLandExcessWeightWithTractorTruckTest() {
    Land land = new Land(LandType.UNPAVED.name());
    Vehicle vehicle = new Truck(TruckType.TRACTOR.name());
    int kmTraveled = 10;
    int weightCargo = 6;
    assertThat(land.calculateTotalCost(vehicle, kmTraveled, weightCargo)).isEqualTo(7.144000000000001);
  }
}
