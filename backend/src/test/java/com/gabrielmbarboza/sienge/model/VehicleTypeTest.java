package com.gabrielmbarboza.sienge.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gabrielmbarboza.sienge.exception.TruckTypeNotFoundException;
import com.gabrielmbarboza.sienge.exception.VehicleCategoryNotFoundException;
import com.gabrielmbarboza.sienge.exception.VehicleTypeNotFoundException;

@SpringBootTest
public class VehicleTypeTest {

  @Test
  public void getVehicleTypeBoxTest() {
    VehicleType vehicleType = new VehicleType("truck", "box");
    assertThat(vehicleType.getVehicle().getClass(), is(Truck.class));
  }

  @Test
  public void getVehicleTypeDumpTest() {
    VehicleType vehicleType = new VehicleType("truck", "dump");
    assertThat(vehicleType.getVehicle().getClass(), is(Truck.class));
  }

  @Test
  public void getVehicleTypeTractorTest() {
    VehicleType vehicleType = new VehicleType("truck", "tractor");
    assertThat(vehicleType.getVehicle().getClass(), is(Truck.class));
  }

  @Test
  public void getVehicleTypeWithInvalidCategoryTest() {
    VehicleType vehicleType = new VehicleType("car", "dump");
    VehicleCategoryNotFoundException thrown = assertThrows(VehicleCategoryNotFoundException.class,
        () -> vehicleType.getVehicle(),
        "Expected getVehicle to throw, category not found");
    assertThat(thrown.getMessage(), equalTo("Vehicle category not found."));
  }

  @Test
  public void getVehicleTypeWithInvalidTypeTest() {
    VehicleType vehicleType = new VehicleType("truck", "tank");
    TruckTypeNotFoundException thrown = assertThrows(TruckTypeNotFoundException.class,
        () -> vehicleType.getVehicle(),
        "Expected getVehicle to throw, type not found");
    assertThat(thrown.getMessage(), equalTo("Truck type not found."));
  }

  @Test
  public void getVehicleTypeWithEmptyCategoryTest() {
    VehicleType vehicleType = new VehicleType(null, "dump");
    VehicleCategoryNotFoundException thrown = assertThrows(VehicleCategoryNotFoundException.class,
        () -> vehicleType.getVehicle(),
        "Expected getVehicle to throw, category is null");
    assertThat(thrown.getMessage(), equalTo("Vehicle category not found."));
  }

  @Test
  public void getVehicleTypeWithEmptyTypeTest() {
    VehicleType vehicleType = new VehicleType("truck", null);
    VehicleTypeNotFoundException thrown = assertThrows(VehicleTypeNotFoundException.class,
        () -> vehicleType.getVehicle(),
        "Expected getVehicle to throw, type is null");
    assertThat(thrown.getMessage(), equalTo("Vehicle type not found."));
  }
}
