package com.study.jwtsample.common;

import com.study.jwtsample.common.exception.CommonException;
import com.study.jwtsample.common.exception.ExceptionResponse;
import com.study.jwtsample.common.exception.code.ApiExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.study.jwtsample.common.exception.code.ApiExceptionCode.AE_401_10000;
import static com.study.jwtsample.common.exception.code.ApiExceptionCode.AE_500_10000;

@RestControllerAdvice
public class ControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(value = {CommonException.class})
    public ResponseEntity<ExceptionResponse> commonExceptionHandler(CommonException e) {
        logger.info(e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(
            new ExceptionResponse(e.getCode(), e.getMessage())
        );
    }

    @ExceptionHandler(value = {InternalAuthenticationServiceException.class})
    public ResponseEntity<ExceptionResponse> internalAuthenticationServiceExceptionHandler(Exception e) {
        logger.info(e.getMessage());
        return ResponseEntity.internalServerError().body(
            new ExceptionResponse(AE_401_10000.getCode(), e.getMessage())
        );
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionResponse> exceptionHandler(Exception e) {
        logger.info(e.getMessage());
        return ResponseEntity.internalServerError().body(
                new ExceptionResponse(AE_500_10000.getCode(), AE_500_10000.getMessage())
        );
    }
}
