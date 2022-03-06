package com.gabrielmbarboza.sienge.errors;

import com.gabrielmbarboza.sienge.exception.NegativeKmException;
import com.gabrielmbarboza.sienge.exception.NegativeWeightCargoException;
import com.gabrielmbarboza.sienge.exception.TruckTypeNotFoundException;
import com.gabrielmbarboza.sienge.exception.VehicleCategoryNotFoundException;
import com.gabrielmbarboza.sienge.exception.VehicleTypeNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class CustomControllerAdvice {

  @ExceptionHandler(value = NullPointerException.class)
  public ResponseEntity<ErrorResponse> nullPointerException(NullPointerException e) {
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
  }

  @ExceptionHandler(value = MissingServletRequestParameterException.class)
  public ResponseEntity<ErrorResponse> negativeWeightCargoException(MissingServletRequestParameterException e) {
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
  }

  @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorResponse> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
  }

  @ExceptionHandler(value = NegativeWeightCargoException.class)
  public ResponseEntity<ErrorResponse> negativeWeightCargoException(NegativeWeightCargoException e) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
  }

  @ExceptionHandler(value = NegativeKmException.class)
  public ResponseEntity<ErrorResponse> negativeKmException(NegativeKmException e) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
  }

  @ExceptionHandler(value = TruckTypeNotFoundException.class)
  public ResponseEntity<ErrorResponse> truckTypeNotFoundException(TruckTypeNotFoundException e) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
  }

  @ExceptionHandler(value = VehicleCategoryNotFoundException.class)
  public ResponseEntity<ErrorResponse> vehicleCategoryNotFoundException(VehicleCategoryNotFoundException e) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
  }

  @ExceptionHandler(value = VehicleTypeNotFoundException.class)
  public ResponseEntity<ErrorResponse> vehicleTypeNotFoundException(VehicleTypeNotFoundException e) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
  }
}
