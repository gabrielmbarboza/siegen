package com.gabrielmbarboza.sienge.service;

import com.gabrielmbarboza.sienge.dto.TransportTotalCost;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CostCalculationServiceTest {

  @Autowired
  CostCalculationService calculationService;

  @Test
  public void costPavedLandDumpTruckTest() {
    String expected = "62,70";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", 100, 0, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedLandBoxTruckTest() {
    String expected = "60,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", 100, 0, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedLandTractorTruckTest() {
    String expected = "66,48";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", 100, 0, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costUnpavedLandDumpTruckTest() {
    String expected = "71,10";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", 0, 100, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costUnpavedLandBoxTruckTest() {
    String expected = "68,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", 0, 100, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costUnpavedLandTractorTruckTest() {
    String expected = "75,44";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", 0, 100, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandDumpTruckTest() {
    String expected = "133,80";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", 100, 100, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandBoxTruckTest() {
    String expected = "128,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", 100, 100, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandTractorTruckTest() {
    String expected = "141,92";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", 100, 100, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandDumpTruckZeroWeightTest() {
    String expected = "121,80";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", 100, 100, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandDumpTruckNegativeWeightTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", 100, 100, -8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandBoxTruckZeroWeightTest() {
    String expected = "116,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", 100, 100, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandBoxTruckNegativeWeightTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", 100, 100, -8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandTractorTruckZeroWeightTest() {
    String expected = "129,92";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", 100, 100, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandTractorTruckNegativeWeightTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", 100, 100, -8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedLandDumpTruckNegativeKmTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", -100, 0, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedLandBoxTruckNegativeKmTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", -100, 0, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedLandTractorTruckNegativeKmTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", -100, 0, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costUnpavedLandDumpTruckNegativeKmTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", 0, -100, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costUnpavedLandBoxTruckNegativeKmTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", 0, -100, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costUnpavedLandTractorTruckNegativeKmTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", 0, -100, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandDumpTruckNegativeKmTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", -100, -100, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandBoxTruckNegativeKmTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", -100, -100, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandTractorTruckNegativeKmtTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", -100, -100, 8);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandDumpTruckZeroKmAndWeightTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", 0, 0, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandBoxTruckZeroKmAndWeightTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", 0, 0, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

  @Test
  public void costPavedAndUnpavedLandTractorTruckZeroKmAndWeightTest() {
    String expected = "0,00";
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", 0, 0, 0);
    assertThat(expected).isEqualTo(transportTotalCost.getTotalCost());
  }

}
