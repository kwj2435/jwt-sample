package com.study.jwtsample.member.service;

import com.study.jwtsample.member.entity.MemberEntity;
import com.study.jwtsample.member.model.MemberModel;
import com.study.jwtsample.member.repository.MemberEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberEntityRepository memberEntityRepository;

    public MemberModel.Member addMember(MemberModel.MemberRequestDto requestDto) {
        MemberEntity memberEntity = MemberEntity.createForNewMember(requestDto, passwordEncoder);

        return memberEntityRepository.save(memberEntity).toMember();
    }
}
