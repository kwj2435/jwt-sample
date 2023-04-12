package com.study.jwtsample.common.exception;

public class ExceptionResponse<T> {
    private String exceptionCode;
    private String message;
    private T data;
}
