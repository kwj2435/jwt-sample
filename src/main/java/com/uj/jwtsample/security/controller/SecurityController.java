package com.uj.jwtsample.security.controller;

import com.uj.jwtsample.security.model.Authenticate;
import com.uj.jwtsample.security.model.Authenticate.AuthRequestDto;
import com.uj.jwtsample.security.model.Token.TokenInfo;
import com.uj.jwtsample.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security")
@RequiredArgsConstructor
public class SecurityController {

  private AuthService authService;

  // 로그인
  // RefreshToken 재발급
  @PostMapping("/auth")
  public TokenInfo authenticate(@RequestBody AuthRequestDto authRequestDto) {
    return authService.authByEmailAndPassword(authRequestDto.getEmail(), authRequestDto.getPassword());
  }
}
