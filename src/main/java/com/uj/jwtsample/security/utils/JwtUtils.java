package com.uj.jwtsample.security.utils;

import static com.uj.jwtsample.security.enums.TokenType.RT;

import com.uj.jwtsample.security.enums.TokenType;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
  private final Key jwtAccessKey;
  private final Key jwtRefresKey;
  private final static long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 10;
  private final static long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 10 * 30;

  // JWT 생성시 사용되던 기존 signWith가 Deprecated 되어
  // 아래와 같이 byte key를 만든후 signWith에 넣어줘야한다.
  public JwtUtils(
      @Value("${jwt.secret.access-token}") String accessKey,
      @Value("${jwt.secret.refresh-token}") String refreshKey) {
    byte[] accessKeyBytes = Decoders.BASE64.decode(accessKey);
    byte[] refreshKeyBytes = Decoders.BASE64.decode(refreshKey);
    this.jwtAccessKey = Keys.hmacShaKeyFor(accessKeyBytes);
    this.jwtRefresKey = Keys.hmacShaKeyFor(refreshKeyBytes);
  }
  /**
   * 토큰 생성
   * Claims -
   * Subject -
   * IssuedAt -
   * Expiration -
   */
  public String createToken(String email, TokenType tokenType) {
    Map<String, Object> claims = new HashMap<>();
    long expireTime = ACCESS_TOKEN_EXPIRE_TIME;
    Key secretKey = jwtAccessKey;

    if(RT.equals(tokenType)) {
      expireTime = REFRESH_TOKEN_EXPIRE_TIME;
      secretKey = jwtRefresKey;
    }

    return Jwts.builder()
        .setClaims(claims)
        .setSubject(email)
        .setIssuedAt(new Date(System.currentTimeMillis() + expireTime))
        .signWith(secretKey, SignatureAlgorithm.HS256)
        .compact();
  }
}
