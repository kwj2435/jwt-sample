package com.study.jwtsample.controller;

import com.study.jwtsample.model.MemberModel;
import com.study.jwtsample.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public MemberModel.Member addMember(@RequestBody MemberModel.MemberRequestDto requestDto) {
        return memberService.addMember(requestDto);
    }
}
