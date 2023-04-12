package com.study.jwtsample.common.exception.code;

import org.springframework.http.HttpStatus;

public enum ApiExceptionCode implements ExceptionCode {
    AE_400_10000(HttpStatus.BAD_REQUEST, "400_10000", "입력된 두개의 비밀번호가 일치하지 않습니다.");

    private HttpStatus status;
    private String code;
    private String message;

    ApiExceptionCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
