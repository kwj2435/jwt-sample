package com.uj.jwtsample.security.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TokenType {
  AT("AT", "AccessToken"),
  RT("RT", "RefreshToken");

  private final String type;
  private final String description;
}
