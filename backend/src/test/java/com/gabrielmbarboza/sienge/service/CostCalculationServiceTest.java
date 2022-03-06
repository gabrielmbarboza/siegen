package com.gabrielmbarboza.sienge.service;

import com.gabrielmbarboza.sienge.dto.TransportTotalCost;
import com.gabrielmbarboza.sienge.exception.NegativeKmException;
import com.gabrielmbarboza.sienge.exception.NegativeWeightCargoException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CostCalculationServiceTest {
  private Double kmByPavedLand = 100d;
  private Double kmByPavedLandZero = 0d;
  private Double kmByPavedLandNegative = -100d;
  private Double kmByUnpavedLand = 100d;
  private Double kmByUnpavedLandZero = 0d;
  private Double kmByUnpavedLandNegative = -100d;
  private Double weightCargo = 8d;
  private Double weightCargoZero = 0d;
  private Double weightCargoNegative = -8d;

  @Autowired
  CostCalculationService calculationService;

  @Test
  public void costPavedLandDumpTruckTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", kmByPavedLand,
        kmByUnpavedLandZero, weightCargo);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("62.70");
  }

  @Test
  public void costPavedLandBoxTruckTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", kmByPavedLand,
        kmByUnpavedLandZero, weightCargo);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("60.00");
  }

  @Test
  public void costPavedLandTractorTruckTest() {

    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", kmByPavedLand,
        kmByUnpavedLandZero, weightCargo);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("66.48");
  }

  @Test
  public void costUnpavedLandDumpTruckTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", kmByPavedLandZero,
        kmByUnpavedLand, weightCargo);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("71.10");
  }

  @Test
  public void costUnpavedLandBoxTruckTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", kmByPavedLandZero,
        kmByUnpavedLand, weightCargo);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("68.00");
  }

  @Test
  public void costUnpavedLandTractorTruckTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", kmByPavedLandZero,
        kmByUnpavedLand, weightCargo);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("75.44");
  }

  @Test
  public void costPavedAndUnpavedLandDumpTruckTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", kmByPavedLand,
        kmByUnpavedLand, weightCargo);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("133.80");
  }

  @Test
  public void costPavedAndUnpavedLandBoxTruckTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", kmByPavedLand,
        kmByUnpavedLand, weightCargo);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("128.00");
  }

  @Test
  public void costPavedAndUnpavedLandTractorTruckTest() {

    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", kmByPavedLand,
        kmByUnpavedLand, weightCargo);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("141.92");
  }

  @Test
  public void costPavedAndUnpavedLandDumpTruckZeroWeightTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", kmByPavedLand,
        kmByUnpavedLandZero, weightCargoZero);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("56.70");
  }

  @Test
  public void costPavedAndUnpavedLandDumpTruckNegativeWeightTest() {
    NegativeWeightCargoException thrown = assertThrows(NegativeWeightCargoException.class,
        () -> calculationService.calculateCost("TRUCK", "DUMP", kmByPavedLand,
            kmByUnpavedLandNegative, weightCargoNegative),
        "Expected calculateTotalCost to throw, weight cargo is negative");
    assertThat(thrown.getMessage(), equalTo("The weight of the cargo cannot be negative."));
  }

  @Test
  public void costPavedAndUnpavedLandBoxTruckZeroWeightTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", kmByPavedLand,
        kmByUnpavedLandZero, weightCargoZero);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("54.00");
  }

  @Test
  public void costPavedAndUnpavedLandBoxTruckNegativeWeightTest() {
    NegativeWeightCargoException thrown = assertThrows(NegativeWeightCargoException.class,
        () -> calculationService.calculateCost("TRUCK", "BOX", kmByPavedLand,
            kmByUnpavedLandNegative, weightCargoNegative),
        "Expected calculateTotalCost to throw, weight cargo is negative");
    assertThat(thrown.getMessage(), equalTo("The weight of the cargo cannot be negative."));
  }

  @Test
  public void costPavedAndUnpavedLandTractorTruckZeroWeightTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", kmByPavedLand,
        kmByUnpavedLandZero, weightCargoZero);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("60.48");
  }

  @Test
  public void costPavedAndUnpavedLandTractorTruckNegativeWeightTest() {
    NegativeWeightCargoException thrown = assertThrows(NegativeWeightCargoException.class,
        () -> calculationService.calculateCost("TRUCK", "TRACTOR", kmByPavedLand,
            kmByUnpavedLandNegative, weightCargoNegative),
        "Expected calculateTotalCost to throw, weight cargo is negative");
    assertThat(thrown.getMessage(), equalTo("The weight of the cargo cannot be negative."));
  }

  @Test
  public void costPavedLandDumpTruckNegativeKmTest() {
    NegativeKmException thrown = assertThrows(NegativeKmException.class,
        () -> calculationService.calculateCost("TRUCK", "DUMP", kmByPavedLandNegative,
            kmByUnpavedLandZero, weightCargoZero),
        "Expected calculateTotalCost to throw, km negative");
    assertThat(thrown.getMessage(), equalTo("Mileage cannot be a negative."));
  }

  @Test
  public void costPavedLandBoxTruckNegativeKmTest() {
    NegativeKmException thrown = assertThrows(NegativeKmException.class,
        () -> calculationService.calculateCost("TRUCK", "BOX", kmByPavedLandNegative,
            kmByUnpavedLandZero, weightCargoZero),
        "Expected calculateTotalCost to throw, km negative");
    assertThat(thrown.getMessage(), equalTo("Mileage cannot be a negative."));
  }

  @Test
  public void costPavedLandTractorTruckNegativeKmTest() {
    NegativeKmException thrown = assertThrows(NegativeKmException.class,
        () -> calculationService.calculateCost("TRUCK", "TRACTOR", kmByPavedLandNegative,
            kmByUnpavedLandZero, weightCargoZero),
        "Expected calculateTotalCost to throw, km negative");
    assertThat(thrown.getMessage(), equalTo("Mileage cannot be a negative."));
  }

  @Test
  public void costUnpavedLandDumpTruckNegativeKmTest() {
    NegativeKmException thrown = assertThrows(NegativeKmException.class,
        () -> calculationService.calculateCost("TRUCK", "DUMP", kmByPavedLandZero,
            kmByUnpavedLandNegative, weightCargoZero),
        "Expected calculateTotalCost to throw, km negative");
    assertThat(thrown.getMessage(), equalTo("Mileage cannot be a negative."));
  }

  @Test
  public void costUnpavedLandBoxTruckNegativeKmTest() {
    NegativeKmException thrown = assertThrows(NegativeKmException.class,
        () -> calculationService.calculateCost("TRUCK", "BOX", kmByPavedLandZero,
            kmByUnpavedLandNegative, weightCargoZero),
        "Expected calculateTotalCost to throw, km negative");
    assertThat(thrown.getMessage(), equalTo("Mileage cannot be a negative."));
  }

  @Test
  public void costUnpavedLandTractorTruckNegativeKmTest() {
    NegativeKmException thrown = assertThrows(NegativeKmException.class,
        () -> calculationService.calculateCost("TRUCK", "TRACTOR", kmByPavedLandZero,
            kmByUnpavedLandNegative, weightCargoZero),
        "Expected calculateTotalCost to throw, km negative");
    assertThat(thrown.getMessage(), equalTo("Mileage cannot be a negative."));
  }

  @Test
  public void costPavedAndUnpavedLandDumpTruckNegativeKmTest() {
    NegativeKmException thrown = assertThrows(NegativeKmException.class,
        () -> calculationService.calculateCost("TRUCK", "DUMP", kmByPavedLandNegative,
            kmByUnpavedLandNegative, weightCargo),
        "Expected calculateTotalCost to throw, km negative");
    assertThat(thrown.getMessage(), equalTo("Mileage cannot be a negative."));
  }

  @Test
  public void costPavedAndUnpavedLandBoxTruckNegativeKmTest() {
    NegativeKmException thrown = assertThrows(NegativeKmException.class,
        () -> calculationService.calculateCost("TRUCK", "BOX", kmByPavedLandNegative,
            kmByUnpavedLandNegative, weightCargo),
        "Expected calculateTotalCost to throw, km negative");
    assertThat(thrown.getMessage(), equalTo("Mileage cannot be a negative."));
  }

  @Test
  public void costPavedAndUnpavedLandTractorTruckNegativeKmtTest() {
    NegativeKmException thrown = assertThrows(NegativeKmException.class,
        () -> calculationService.calculateCost("TRUCK", "TRACTOR", kmByPavedLandNegative,
            kmByUnpavedLandNegative, weightCargo),
        "Expected calculateTotalCost to throw, km negative");
    assertThat(thrown.getMessage(), equalTo("Mileage cannot be a negative."));
  }

  @Test
  public void costPavedAndUnpavedLandDumpTruckZeroKmAndWeightTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "DUMP", kmByPavedLandZero,
        kmByUnpavedLandZero, weightCargoZero);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("0.00");
  }

  @Test
  public void costPavedAndUnpavedLandBoxTruckZeroKmAndWeightTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "BOX", kmByPavedLandZero,
        kmByUnpavedLandZero, weightCargoZero);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("0.00");
  }

  @Test
  public void costPavedAndUnpavedLandTractorTruckZeroKmAndWeightTest() {
    TransportTotalCost transportTotalCost = calculationService.calculateCost("TRUCK", "TRACTOR", kmByPavedLandZero,
        kmByUnpavedLandZero, weightCargoZero);
    String result = transportTotalCost.getTotalCost();
    assertThat(result).isEqualTo("0.00");
  }

}
