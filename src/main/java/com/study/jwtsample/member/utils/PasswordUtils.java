package com.study.jwtsample.member.utils;

public class PasswordUtils {

    public static boolean isValidatePassword(String password, String passwordCheck) {
        return password.equals(passwordCheck);
    }
}
