package com.uj.jwtsample.member.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRoles {

  USER("USER", "일반 유저");

  private String role;
  private String description;

}
