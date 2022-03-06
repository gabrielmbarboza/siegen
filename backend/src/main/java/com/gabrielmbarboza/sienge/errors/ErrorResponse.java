package com.gabrielmbarboza.sienge.errors;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  private Date timestamp;
  @JsonFormat
  private int code;
  @JsonFormat
  private String status;
  @JsonFormat
  private String message;
  @JsonFormat
  private String stackTrace;
  @JsonFormat
  private Object data;

  public ErrorResponse() {
    timestamp = new Date();
  }

  public ErrorResponse(HttpStatus httpStatus, String message) {
    this();
    this.code = httpStatus.value();
    this.status = httpStatus.name();
    this.message = message;
  }

  public ErrorResponse(HttpStatus httpStatus, String message, String stackTrace) {
    this(httpStatus, message);
    this.stackTrace = stackTrace;
  }

  public ErrorResponse(HttpStatus httpStatus, String message, String stackTrace, Object data) {
    this(httpStatus, message, stackTrace);
    this.data = data;
  }
}
