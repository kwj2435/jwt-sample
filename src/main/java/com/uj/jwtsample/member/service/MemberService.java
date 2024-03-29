package com.uj.jwtsample.member.service;

import static com.uj.jwtsample.common.exception.ExceptionCode.ERROR_MEMBER_400_003;

import com.uj.jwtsample.common.exception.BaseException;
import com.uj.jwtsample.common.exception.ExceptionCode;
import com.uj.jwtsample.member.entity.MemberEntity;
import com.uj.jwtsample.member.mapper.MemberMapper;
import com.uj.jwtsample.member.model.Member.MemberRegistDto;
import com.uj.jwtsample.member.model.Member.MemberResult;
import com.uj.jwtsample.member.repository.MemberRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  private final MemberMapper memberMapper;

  private final PasswordEncoder passwordEncoder;

  public MemberResult registMember(MemberRegistDto registDto) {
    if(!isValidPassword(registDto.getPassword(), registDto.getPasswordCheck())) {
      throw new BaseException(ExceptionCode.ERROR_MEMBER_400_001);
    }

    MemberEntity savedMemberEntity =
        memberRepository.save(memberMapper.toMemberEntity(registDto));

    return memberMapper.toResult(savedMemberEntity);
  }

  /** 패스워드 유효성 검사*/
  private boolean isValidPassword(String s1, String s2) {
    return Objects.equals(s1, s2);
  }

  public MemberResult getMember(String email) {
    MemberEntity memberEntity =
        memberRepository.findByEmail(email).orElseThrow(() -> new BaseException(ERROR_MEMBER_400_003));

    return memberMapper.toResult(memberEntity);
  }
}
