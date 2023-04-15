package com.study.jwtsample.security.service;

import com.study.jwtsample.common.exception.CommonException;
import com.study.jwtsample.common.exception.code.ApiExceptionCode;
import com.study.jwtsample.member.entity.MemberEntity;
import com.study.jwtsample.member.repository.MemberEntityRepository;
import com.study.jwtsample.security.model.SecurityModel;
import com.study.jwtsample.security.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final MemberEntityRepository memberEntityRepository;

    public SecurityModel.Token authenticate(SecurityModel.AuthenticateDto authenticateDto) {
        // 1. 전달 받은 로그인 정보를 인증 토큰으로 변환
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authenticateDto.getEmail(), authenticateDto.getPassword());

        // 2. 인증 토큰의 유효성을 검사하여 유효할 경우 Authentication 객체를 반환 ( 내부적으로 UserDetailService 로드 )
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 유효한 인증 토큰을 SecurityContext에 등록하여 추후 인증에 통과할 수 있도록 처리
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 4. 인증 토큰 기반으로 생성된 토큰을 반환한다.
        return JwtUtils.generateToken(authentication);
    }

    // loadUserByUsername에서 만들어진 UserDetails와 사용자 요청의 아이디, 패스워드를 비교하며 일치한지를 확인한다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity memberEntity =
                memberEntityRepository.findByEmail(username).orElseThrow(() -> new CommonException(ApiExceptionCode.AE_404_10000));

        return User.builder()
                .username(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .authorities(getGrantedAuthorities())
                .build();
    }

    private List<GrantedAuthority> getGrantedAuthorities() {
        return List.of(new SimpleGrantedAuthority("test"));
    }

}
