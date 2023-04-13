package com.study.jwtsample.common;

import com.study.jwtsample.common.exception.CommonException;
import com.study.jwtsample.common.exception.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = {CommonException.class})
    public ResponseEntity<ExceptionResponse> commonExceptionHandler(CommonException e) {
        return null;
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> exceptionHandler(Exception e) {

        return ResponseEntity
                .internalServerError()
                .body(e.getMessage());
    }
}
