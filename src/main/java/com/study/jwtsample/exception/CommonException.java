package com.study.jwtsample.exception;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException{
    private HttpStatus status;
    private String code;
    private String message;

    public CommonException(ExceptionCode exceptionCode) {

    }
}
