package com.study.jwtsample.common.exception.code;

import org.springframework.http.HttpStatus;

public enum ApiExceptionCode implements ExceptionCode {
    AE_400_10000(HttpStatus.BAD_REQUEST, "400_10000", "입력된 두개의 비밀번호가 일치하지 않습니다."),
    AE_400_10001(HttpStatus.BAD_REQUEST, "400_10001", "중복된 이메일이 존재합니다."),

    AE_401_10000(HttpStatus.UNAUTHORIZED, "401_10000", "인증 실패"),

    AE_404_10000(HttpStatus.NOT_FOUND, "404_10000", "존재하지 않는 회원 입니다."),

    AE_500_10000(HttpStatus.INTERNAL_SERVER_ERROR, "500_10000", "관리자의 확인이 필요 합니다.");

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
