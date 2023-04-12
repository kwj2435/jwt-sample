package com.study.jwtsample.common;

import org.springframework.http.HttpStatus;

public class ApiResult {
    HttpStatus status;
    Object result;

    public ApiResult(HttpStatus status, Object result) {
        this.status = status;
        this.result = result;
    }
}
