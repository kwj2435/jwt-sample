package com.study.jwtsample.security.model;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class SecurityModel {

    @Getter
    @Builder
    public static class Token {
        private String accessToken;
        private String refreshToken;
    }

    @Getter
    public static class AuthenticateDto {
        @Email
        @NotNull
        private String email;
        @NotNull
        private String password;
    }
}
