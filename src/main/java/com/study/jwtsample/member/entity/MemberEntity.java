package com.study.jwtsample.member.entity;

import com.study.jwtsample.common.exception.code.ApiExceptionCode;
import com.study.jwtsample.common.exception.CommonException;
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

    @Column(name = "USER_EMAIL")
    private String userEmail;

    private String password;

    private String authority;

    public MemberModel.Member toMember() {
        return MemberModel.Member.builder()
                .id(this.id)
                .email(this.userEmail)
                .authority(this.authority)
                .build();
    }

    public static MemberEntity createForNewMember(MemberModel.MemberRequestDto requestDto, PasswordEncoder passwordEncoder) {
        if(PasswordUtils.isNotValidatePassword(requestDto.getPassword(), requestDto.getPasswordCheck())) {
            throw new CommonException(ApiExceptionCode.AE_400_10000);
        }

        return MemberEntity.builder()
                .userEmail(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .authority("REGULAR")   //todo 추후 별도 ENUM 처리
                .build();
    }
}
