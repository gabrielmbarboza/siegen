package com.gabrielmbarboza.sienge.controller;

import com.gabrielmbarboza.sienge.dto.TransportTotalCost;
import com.gabrielmbarboza.sienge.exception.NegativeWeightCargoException;
import com.gabrielmbarboza.sienge.service.CostCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostCalculationController {

  @Autowired
  CostCalculationService costCalculationService;

  @CrossOrigin
  @RequestMapping("/cost/calculation")
  public ResponseEntity<?> costCalculation(
      @RequestParam(value = "vehicle_category") String vehicleCategory,
      @RequestParam(value = "vehicle_type") String vehicleType,
      @RequestParam(value = "paved_km", required = false) Double kmByPavedLand,
      @RequestParam(value = "unpaved_km", required = false) Double kmByUnpavedLand,
      @RequestParam(value = "weight_cargo") Double weightCargo) {

    TransportTotalCost transportTotalCost = costCalculationService.calculateCost(vehicleCategory, vehicleType,
        kmByPavedLand, kmByUnpavedLand, weightCargo);

    return new ResponseEntity<TransportTotalCost>(transportTotalCost,
        HttpStatus.OK);
  }
}
