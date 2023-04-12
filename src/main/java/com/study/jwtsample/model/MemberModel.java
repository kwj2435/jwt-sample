package com.study.jwtsample.model;

import com.study.jwtsample.exception.ApiExceptionCode;
import com.study.jwtsample.exception.CommonException;
import com.study.jwtsample.utils.PasswordUtils;
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
