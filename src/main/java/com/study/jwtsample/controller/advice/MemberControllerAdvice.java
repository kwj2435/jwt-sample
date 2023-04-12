package com.study.jwtsample.controller.advice;

import com.study.jwtsample.exception.CommonException;
import com.study.jwtsample.exception.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MemberControllerAdvice {

    @ExceptionHandler(value = {CommonException.class})
    public ResponseEntity<ExceptionResponse> commonExceptionHandelr(CommonException e) {
        return null;
    }
}
