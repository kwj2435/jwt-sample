package com.uj.jwtsample.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

//  // todo 아래 코드 동작 안함
//  @ExceptionHandler(MethodArgumentNotValidException.class)
//  public ResponseEntity<BaseException> MethodArgumentNotValidExceptionHandler() {
//    return ResponseEntity.badRequest().body(new BaseException(ExceptionCode.ERROR_MEMBER_400_01));
//  }
}
