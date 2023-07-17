package com.uj.jwtsample.member.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class Member {

  @Getter
  public static class MemberRegistDto {
    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String passwordCheck;

    @NotNull
    private String name;
  }

  @Getter
  @NoArgsConstructor
  @Builder
  @AllArgsConstructor
  public static class MemberResult {
    private String email;

    private String name;
  }
}
