package com.study.jwtsample.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ExceptionResponse<T> {
    private String exceptionCode;
    private String message;
    private T data;
}
