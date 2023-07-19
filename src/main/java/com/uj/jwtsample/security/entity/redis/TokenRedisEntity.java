package com.uj.jwtsample.security.entity.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash(value = "rt", timeToLive = 30*30*30)
@AllArgsConstructor
public class TokenRedisEntity {

  @Id
  private String email;
  private String refreshToken;
}
