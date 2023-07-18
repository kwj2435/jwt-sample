package com.uj.jwtsample.security.model;

import lombok.Getter;

public class Authenticate {

  @Getter
  public static class AuthRequestDto {
    private String email;
    private String password;
  }
}
