package com.uj.jwtsample.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

  ERROR_MEMBER_400_01("EM_403_01", "입력된 비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST),

  ERROR_COMMON_400_01("EC_400_01", "잘못된 파라미터 입니다.", HttpStatus.BAD_REQUEST);

  private final String code;
  private final String description;
  private final HttpStatus httpStatus;
}
