package com.uj.jwtsample.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

//  // todo 아래 코드 동작 안함
//  @ExceptionHandler(MethodArgumentNotValidException.class)
//  public ResponseEntity<BaseException> MethodArgumentNotValidExceptionHandler() {
//    return ResponseEntity.badRequest().body(new BaseException(ExceptionCode.ERROR_MEMBER_400_01));
//  }

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<CommonErrorResponse> baseExceptionHandler(BaseException e) {
    log.error(e.getMessage());
    return ResponseEntity.status(e.getHttpStatus()).body(new CommonErrorResponse(e));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<CommonErrorResponse> exceptionHandler(Exception e) {
    log.error(e.getMessage());
    BaseException internalServiceErrorException =
        new BaseException(ExceptionCode.ERROR_SYSTEM_500_001);
    return ResponseEntity.internalServerError()
        .body(new CommonErrorResponse(internalServiceErrorException));
  }
}
