package com.study.jwtsample.member.service;

import com.study.jwtsample.common.exception.CommonException;
import com.study.jwtsample.common.exception.code.ApiExceptionCode;
import com.study.jwtsample.member.entity.MemberEntity;
import com.study.jwtsample.member.model.MemberModel;
import com.study.jwtsample.member.repository.MemberEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberEntityRepository memberEntityRepository;

    /**
     *  회원 등록
     */
    public MemberModel.Member addMember(MemberModel.MemberRequestDto requestDto) {
        if(memberEntityRepository.findByUserEmail(requestDto.getEmail()).isPresent()) {
            throw new CommonException(ApiExceptionCode.AE_400_10001);
        }
        MemberEntity memberEntity = MemberEntity.createForNewMember(requestDto, passwordEncoder);

        return memberEntityRepository.save(memberEntity).toMember();
    }
}
