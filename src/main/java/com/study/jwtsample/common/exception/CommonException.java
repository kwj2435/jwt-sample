package com.study.jwtsample.common.exception;

import com.study.jwtsample.common.exception.code.ExceptionCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonException extends RuntimeException{
    private HttpStatus status;
    private String code;
    private String message;

    public CommonException(ExceptionCode exceptionCode) {
        this.status = exceptionCode.getStatus();
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }
}
