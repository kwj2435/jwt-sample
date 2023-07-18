package com.uj.jwtsample.security.service;

import com.uj.jwtsample.common.exception.BaseException;
import com.uj.jwtsample.common.exception.ExceptionCode;
import com.uj.jwtsample.member.entity.MemberEntity;
import com.uj.jwtsample.member.enums.UserRoles;
import com.uj.jwtsample.member.mapper.MemberMapper;
import com.uj.jwtsample.member.model.Member.MemberResult;
import com.uj.jwtsample.member.repository.MemberRepository;
import com.uj.jwtsample.security.model.Token.TokenInfo;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

  private final MemberRepository memberRepository;

  private final PasswordEncoder passwordEncoder;

  private final MemberMapper memberMapper;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    MemberEntity memberEntity =
        memberRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));

    // 유저 권한 세팅
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    grantedAuthorities.add(new SimpleGrantedAuthority(UserRoles.USER.getRole()));

    return new User(memberEntity.getEmail(), memberEntity.getPassword(), grantedAuthorities);
  }

  public TokenInfo authByEmailAndPassword(String email, String password) {
    MemberEntity memberEntity = memberRepository.findByEmail(email).orElseThrow(
        () -> new BaseException(ExceptionCode.ERROR_MEMBER_400_02));

    if(!passwordEncoder.matches(password, memberEntity.getPassword())) {
      throw new BaseException(ExceptionCode.ERROR_MEMBER_400_02);
    }

    return new TokenInfo("abc", "def");
  }
}
