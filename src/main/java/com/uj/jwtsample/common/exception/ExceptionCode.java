package com.uj.jwtsample.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

  ERROR_MEMBER_400_01("EM_400_01", "입력된 비밀번호가 동일하지 않습니다.", HttpStatus.BAD_REQUEST),
  ERROR_MEMBER_400_02("EM_400_02", "아이디 혹은 비밀번호를 확인해주세요.", HttpStatus.BAD_REQUEST),

  ERROR_COMMON_400_01("EC_400_01", "잘못된 파라미터 입니다.", HttpStatus.BAD_REQUEST);

  private final String code;
  private final String description;
  private final HttpStatus httpStatus;
}
