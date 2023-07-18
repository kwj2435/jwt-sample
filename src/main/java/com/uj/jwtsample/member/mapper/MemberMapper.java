package com.uj.jwtsample.member.mapper;

import com.uj.jwtsample.member.entity.MemberEntity;
import com.uj.jwtsample.member.model.Member.MemberRegistDto;
import com.uj.jwtsample.member.model.Member.MemberResult;
import com.uj.jwtsample.member.service.MemberService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Mapper prefix - 도메인명
 */
@Mapper(componentModel = "spring", uses = MemberService.class)
public interface MemberMapper {

  @Mapping(source = "registDto.password", target = "password", qualifiedByName = "encryptPassword")
  MemberEntity toMemberEntity(MemberRegistDto registDto);
  MemberResult toResult(MemberEntity memberEntity);

  @Named("encryptPassword")
  default String encryptPassword(String decryptPassword) {
    return new BCryptPasswordEncoder().encode(decryptPassword);
  }
}
