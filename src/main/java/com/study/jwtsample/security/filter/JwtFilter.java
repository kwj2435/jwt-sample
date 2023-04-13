package com.study.jwtsample.security.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Request에서 Token 추출
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String header = httpServletRequest.getHeader(AUTHORIZATION_HEADER);
    }
}
