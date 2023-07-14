package com.uj.jwtsample.member.repository;

import com.uj.jwtsample.member.entity.MemberEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  @Test
  void save() {
    MemberEntity save = memberRepository.save(
        MemberEntity.builder().email("test").password("test").name("test").build());

    Assertions.assertEquals(save.getEmail(), "test");
  }
}
