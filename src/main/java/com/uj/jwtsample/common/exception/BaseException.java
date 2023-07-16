package com.uj.jwtsample.common.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseException extends RuntimeException{
  private String code;
  private String description;

   public BaseException(ExceptionCode exceptionCode) {
    this.code = exceptionCode.getCode();
    this.description = exceptionCode.getDescription();
  }
}
