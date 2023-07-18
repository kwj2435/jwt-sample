package com.uj.jwtsample.security.model;

import lombok.Getter;

public class Token {

  @Getter
  public static class TokenInfo {
    private String accessToken;
    private String refreshToken;

    public TokenInfo(String at, String rt) {
      this.accessToken = at;
      this.refreshToken = rt;
    }
  }
}
