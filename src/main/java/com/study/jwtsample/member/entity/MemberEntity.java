package com.study.jwtsample.member.entity;

import com.study.jwtsample.common.exception.code.ApiExceptionCode;
import com.study.jwtsample.common.exception.CommonException;
import com.study.jwtsample.member.enums.Authority;
import com.study.jwtsample.member.model.MemberModel;
import com.study.jwtsample.member.utils.PasswordUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "MEMBER")
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    private String password;

    private Authority authority;

    public MemberModel.Member toMember() {
        return MemberModel.Member.builder()
                .id(this.id)
                .email(this.email)
                .build();
    }

    public static MemberEntity createForNewMember(MemberModel.MemberRequestDto requestDto, PasswordEncoder passwordEncoder) {
        if(PasswordUtils.isValidatePassword(requestDto.getPassword(), requestDto.getPasswordCheck())) {
            throw new CommonException(ApiExceptionCode.AE_400_10000);
        }

        return MemberEntity.builder()
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .build();
    }
}
