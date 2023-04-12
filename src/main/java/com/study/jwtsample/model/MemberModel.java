package com.study.jwtsample.model;

import lombok.Builder;
import lombok.Getter;

public class MemberModel {

    @Getter
    @Builder
    public static class Member {
        private long id;
        private String email;
    }

    @Getter
    public static class MemberRequestDto {
        private String email;
        private String password;
        private String passwordCheck;
    }
}
