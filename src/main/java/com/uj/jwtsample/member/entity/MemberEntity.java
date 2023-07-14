package com.uj.jwtsample.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

  /** key */
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long memberId;

  /** 회원 이메일(ID) */
  private String email;

  /** 회원 비밀번호*/
  private String password;

  /** 회원 이름 */
  private String name;
}
