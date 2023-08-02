package com.uj.jwtsample.security.controller;

import static com.uj.jwtsample.common.constant.CommonConstant.ACCESS_TOKEN_HEADER_NAME;

import com.uj.jwtsample.security.model.Authenticate;
import com.uj.jwtsample.security.model.Authenticate.AuthRequestDto;
import com.uj.jwtsample.security.model.Token.TokenInfo;
import com.uj.jwtsample.security.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security")
@RequiredArgsConstructor
public class SecurityController {

  private final AuthService authService;

  // 로그인
  @PostMapping("/auth")
  public TokenInfo authenticate(@RequestBody AuthRequestDto authRequestDto) {
    return authService.authByEmailAndPassword(authRequestDto.getEmail(), authRequestDto.getPassword());
  }

  // 로그아웃
  @DeleteMapping("/logout")
  public void logout(HttpServletRequest request) {
    authService.logout(request.getHeader(ACCESS_TOKEN_HEADER_NAME));
  }

  // RefreshToken 재발급
  @PostMapping("/renew/refresh")
  public TokenInfo renewRefreshToken() {
    return new TokenInfo("123", "123");
  }
}
