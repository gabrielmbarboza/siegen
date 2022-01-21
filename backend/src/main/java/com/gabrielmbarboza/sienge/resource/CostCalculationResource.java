package com.gabrielmbarboza.sienge.resource;

import com.gabrielmbarboza.sienge.dto.TransportTotalCost;
import com.gabrielmbarboza.sienge.service.CostCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostCalculationResource {

  @Autowired
  CostCalculationService costCalculationService;

  @CrossOrigin
  @RequestMapping("/cost/calculation")
  public ResponseEntity<TransportTotalCost> costCalculation(
      @RequestParam(value = "vehicle_category") String vehicleCategory,
      @RequestParam(value = "vehicle_type") String vehicleType,
      @RequestParam(value = "paved_km", required = false) int kmByPavedLand,
      @RequestParam(value = "unpaved_km", required = false) int kmByUnpavedLand,
      @RequestParam(value = "weight_cargo") int weightCargo) {

    TransportTotalCost transportTotalCost = costCalculationService.calculateCost(vehicleCategory, vehicleType,
        kmByPavedLand, kmByUnpavedLand, weightCargo);

    return new ResponseEntity<TransportTotalCost>(transportTotalCost,
        HttpStatus.CREATED);
  }
}
