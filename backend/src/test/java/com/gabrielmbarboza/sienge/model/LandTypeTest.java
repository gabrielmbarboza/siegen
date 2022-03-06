package com.gabrielmbarboza.sienge.model;

import com.gabrielmbarboza.sienge.calculation.PavedLandCalculation;
import com.gabrielmbarboza.sienge.calculation.UnpavedLandCalculation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class LandTypeTest {

  @Test
  public void landTypePavedLandCalculationTest() {
    LandType landType = LandType.PAVED;
    assertThat(landType.getTransportCalculation().getClass(), equalTo(PavedLandCalculation.class));
  }

  @Test
  public void landTypeUnpavedLandCalculationTest() {
    LandType landType = LandType.UNPAVED;
    assertThat(landType.getTransportCalculation().getClass(), equalTo(UnpavedLandCalculation.class));
  }
}
