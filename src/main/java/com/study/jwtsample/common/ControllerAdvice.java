package com.study.jwtsample.common;

import com.study.jwtsample.common.exception.CommonException;
import com.study.jwtsample.common.exception.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(value = {CommonException.class})
    public ResponseEntity<ExceptionResponse> commonExceptionHandler(CommonException e) {
        logger.info(e.getMessage());
        return null;
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> exceptionHandler(Exception e) {
        logger.info(e.getMessage());
        return ResponseEntity
                .internalServerError()
                .body(e.getMessage());
    }
}
