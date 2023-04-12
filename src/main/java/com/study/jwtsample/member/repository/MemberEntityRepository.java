package com.study.jwtsample.member.repository;

import com.study.jwtsample.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long> {
}
