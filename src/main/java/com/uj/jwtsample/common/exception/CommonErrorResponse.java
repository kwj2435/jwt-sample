package com.uj.jwtsample.common.exception;

import lombok.Getter;

@Getter
public class CommonErrorResponse {
  private String exceptionCode;
  private String message;
  private String traceId;

  public CommonErrorResponse(BaseException baseException) {
    this.exceptionCode = baseException.getCode();
    this.message = baseException.getDescription();
    this.traceId = "test123"; // todo Request에 대한 traceId를 매핑 해줘야 한다.
  }
}
