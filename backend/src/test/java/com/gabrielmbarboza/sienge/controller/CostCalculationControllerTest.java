package com.gabrielmbarboza.sienge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CostCalculationControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void costCalculation() throws Exception {
    mockMvc.perform(
        get("/cost/calculation")
            .accept(MediaType.APPLICATION_JSON)
            .param("vehicle_category", "TRUCK")
            .param("vehicle_type", "DUMP")
            .param("paved_km", "1")
            .param("unpaved_km", "1")
            .param("weight_cargo", "2"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.vehicle").value("Dump Truck"))
        .andExpect(jsonPath("$.paved_land_cost").value("0.57"))
        .andExpect(jsonPath("$.unpaved_land_cost").value("0.65"))
        .andExpect(jsonPath("$.weight_cargo").value("2.00"))
        .andExpect(jsonPath("$.total_cost").value("1.22"));
  }

  @Test
  public void costCalculationWithoutVehicleCategory() throws Exception {
    mockMvc.perform(
        get("/cost/calculation")
            .accept(MediaType.APPLICATION_JSON)
            .param("vehicle_type", "DUMP")
            .param("paved_km", "1")
            .param("unpaved_km", "1")
            .param("weight_cargo", "2"))
        .andExpect(status().isInternalServerError());
  }

  @Test
  public void costCalculationWithoutVehicleType() throws Exception {
    mockMvc.perform(
        get("/cost/calculation")
            .accept(MediaType.APPLICATION_JSON)
            .param("vehicle_category", "TRUCK")
            .param("paved_km", "1")
            .param("unpaved_km", "1")
            .param("weight_cargo", "2"))
        .andExpect(status().isInternalServerError());
  }

  @Test
  public void costCalculationWithInvalidVehicleCategory() throws Exception {
    mockMvc.perform(
        get("/cost/calculation")
            .accept(MediaType.APPLICATION_JSON)
            .param("vehicle_category", "car")
            .param("vehicle_type", "dump")
            .param("paved_km", "1")
            .param("unpaved_km", "1")
            .param("weight_cargo", "2"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Vehicle category not found."));
  }

  @Test
  public void costCalculationWithInvalidVehicleType() throws Exception {
    mockMvc.perform(
        get("/cost/calculation")
            .accept(MediaType.APPLICATION_JSON)
            .param("vehicle_category", "truck")
            .param("vehicle_type", "tank")
            .param("paved_km", "1")
            .param("unpaved_km", "1")
            .param("weight_cargo", "2"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Truck type not found."));
  }

  @Test
  public void costCalculationWithEmptyVehicleType() throws Exception {
    mockMvc.perform(
        get("/cost/calculation")
            .accept(MediaType.APPLICATION_JSON)
            .param("vehicle_category", "truck")
            .param("vehicle_type", "")
            .param("paved_km", "1")
            .param("unpaved_km", "1")
            .param("weight_cargo", "2"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Vehicle type not found."));
  }
}
