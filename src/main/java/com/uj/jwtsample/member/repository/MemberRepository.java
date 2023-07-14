package com.uj.jwtsample.member.repository;

import com.uj.jwtsample.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
