package com.study.jwtsample.common.exception.code;

import org.springframework.http.HttpStatus;

public interface ExceptionCode {
    HttpStatus getStatus();
    String getCode();
    String getMessage();
}
