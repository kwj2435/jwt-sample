package com.uj.jwtsample.member.mapper;

import com.uj.jwtsample.member.entity.MemberEntity;
import com.uj.jwtsample.member.model.Member.MemberRegistDto;
import com.uj.jwtsample.member.model.Member.MemberResult;
import org.mapstruct.Mapper;

/**
 * Mapper prefix - 도메인명
 */
@Mapper(componentModel = "spring")
public interface MemberMapper {

  MemberEntity toMemberEntity(MemberRegistDto registDto);
  MemberResult toResult(MemberEntity memberEntity);
}
