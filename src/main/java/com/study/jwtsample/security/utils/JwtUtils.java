package com.study.jwtsample.security.utils;

import com.study.jwtsample.security.model.SecurityModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

public class JwtUtils {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public static SecurityModel.Token generateToken(Authentication authentication) {
        return SecurityModel.Token.builder().build();
    }
}
