package com.study.jwtsample.security.controller;

import com.study.jwtsample.member.repository.MemberEntityRepository;
import com.study.jwtsample.security.model.SecurityModel;
import com.study.jwtsample.security.service.AuthService;
import com.study.jwtsample.security.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController{

    private final AuthService authService;

    @PostMapping("/authenticate")
    public SecurityModel.Token authenticate(@Valid @RequestBody SecurityModel.AuthenticateDto authenticateDto) {
        return authService.authenticate(authenticateDto);
    }
}
