package com.study.jwtsample.security.utils;

import com.study.jwtsample.security.SecurityModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public SecurityModel.Token generateToken() {
        return SecurityModel.Token.builder().build();
    }
}
