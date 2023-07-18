package com.uj.jwtsample.security.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.stereotype.Component;

public class JwtUtils {
  private final Key jwtScretKey;
  private final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 10;

  // JWT 생성시 사용되던 기존 signWith가 Deprecated 되어
  // 아래와 같이 byte key를 만든후 signWith에 넣어줘야한다.
  public JwtUtils(@Value("${jwt.secret") String secretKey) {
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    this.jwtScretKey = Keys.hmacShaKeyFor(keyBytes);
  }
  /**
   * 토큰 생성
   * Claims -
   * Subject -
   * IssuedAt -
   * Expiration -
   */
  public String createToken(String email) {
    Map<String, Object> claims = new HashMap<>();

    return Jwts.builder()
        .setClaims(claims)
        .setSubject(email)
        .setIssuedAt(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRE_TIME))
        .signWith(jwtScretKey, SignatureAlgorithm.HS256)
        .compact();
  }
}
