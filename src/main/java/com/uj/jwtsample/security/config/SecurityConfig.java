package com.uj.jwtsample.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((auth) -> auth.anyRequest().permitAll()).csrf(Customizer.withDefaults());
    // http basic - 특정 resource 접근시 브라우저가 사용자에게 username, password 확인을 요청
    http.httpBasic(AbstractHttpConfigurer::disable);
    // CSRF 방지 설정으로 POST, PUT 요청이 막히지 않도록 disable 설정
    http.csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }
}
