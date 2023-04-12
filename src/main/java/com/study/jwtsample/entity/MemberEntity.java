package com.study.jwtsample.entity;

import com.study.jwtsample.exception.ApiExceptionCode;
import com.study.jwtsample.exception.CommonException;
import com.study.jwtsample.model.MemberModel;
import com.study.jwtsample.utils.PasswordUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
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

    public MemberModel.Member toMember() {
        return MemberModel.Member.builder()
                .id(this.id)
                .email(this.email)
                .build();
    }
    public static MemberEntity createForNewMember(MemberModel.MemberRequestDto requestDto) {
        if(PasswordUtils.isValidatePassword(requestDto.getPassword(), requestDto.getPasswordCheck())) {
            throw new CommonException(ApiExceptionCode.AE_400_10000);
        }

        return MemberEntity.builder()
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .build();
    }
}
