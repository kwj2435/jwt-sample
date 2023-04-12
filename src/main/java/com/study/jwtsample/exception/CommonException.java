package com.study.jwtsample.exception;

import com.study.jwtsample.exception.code.ExceptionCode;
import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException{
    private HttpStatus status;
    private String code;
    private String message;

    public CommonException(ExceptionCode exceptionCode) {

    }
}
