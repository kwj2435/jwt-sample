package com.uj.jwtsample.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
