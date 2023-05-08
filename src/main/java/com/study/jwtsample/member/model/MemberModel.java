package com.study.jwtsample.member.model;

import javax.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;

public class MemberModel {

    @Getter
    @Builder
    public static class Member {
        private long id;
        private String email;
        private String authority;
    }

    @Getter
    public static class MemberRequestDto {
        @Email
        private String email;
        private String password;
        private String passwordCheck;
    }
}
