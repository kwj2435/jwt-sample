package com.study.jwtsample.security;

import lombok.Builder;
import lombok.Getter;

public class SecurityModel {

    @Getter
    @Builder
    public static class Token {
        private String accessToken;
        private String refreshToken;
    }
}
