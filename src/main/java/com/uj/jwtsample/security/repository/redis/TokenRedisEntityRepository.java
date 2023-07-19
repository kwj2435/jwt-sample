package com.uj.jwtsample.security.repository.redis;

import com.uj.jwtsample.security.entity.redis.TokenRedisEntity;
import org.springframework.data.repository.CrudRepository;

public interface TokenRedisEntityRepository extends CrudRepository<TokenRedisEntity, String> {

}
