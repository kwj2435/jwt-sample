package com.study.jwtsample.member.controller;

import com.study.jwtsample.member.model.MemberModel;
import com.study.jwtsample.member.service.MemberService;
import javax.validation.Valid;
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
    public MemberModel.Member addMember(@Valid @RequestBody MemberModel.MemberRequestDto requestDto) {
        return memberService.addMember(requestDto);
    }
}
