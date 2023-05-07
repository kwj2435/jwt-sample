package com.study.jwtsample.member.utils;

import org.apache.commons.lang3.StringUtils;

public class PasswordUtils {

    public static boolean isNotValidatePassword(String password, String passwordCheck) {
        return !StringUtils.equals(password, passwordCheck);
    }
}
