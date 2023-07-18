package com.uj.jwtsample.common.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException{
  private String code;
  private String description;
  @JsonIgnore
  private HttpStatus httpStatus;

   public BaseException(ExceptionCode exceptionCode) {
    this.code = exceptionCode.getCode();
    this.description = exceptionCode.getDescription();
    this.httpStatus = exceptionCode.getHttpStatus();
  }
}
