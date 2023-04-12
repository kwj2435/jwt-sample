package com.study.jwtsample.service;

import com.study.jwtsample.entity.MemberEntity;
import com.study.jwtsample.model.MemberModel;
import com.study.jwtsample.repository.MemberEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberEntityRepository memberEntityRepository;

    public MemberModel.Member addMember(MemberModel.MemberRequestDto requestDto) {
        MemberEntity memberEntity = MemberEntity.createForNewMember(requestDto);

        return memberEntityRepository.save(memberEntity).toMember();
    }
}
