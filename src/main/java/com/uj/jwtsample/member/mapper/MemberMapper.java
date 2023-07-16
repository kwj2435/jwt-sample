package com.uj.jwtsample.member.mapper;

import com.uj.jwtsample.member.entity.MemberEntity;
import com.uj.jwtsample.member.model.Member.MemberRegistDto;
import com.uj.jwtsample.member.model.Member.MemberResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper prefix - 도메인명
 */
@Mapper(componentModel = "spring")
public interface MemberMapper {
  MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

  MemberEntity toMemberEntity(MemberRegistDto registDto);
  MemberResult toResult(MemberEntity memberEntity);
}
