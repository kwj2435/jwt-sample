package com.study.jwtsample.member.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Authority {

    REGULAR("REGULAR");

    private String rank;
}
