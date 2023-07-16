package com.uj.jwtsample.member.controller;

import com.uj.jwtsample.member.model.Member.MemberRegistDto;
import com.uj.jwtsample.member.model.Member.MemberResult;
import com.uj.jwtsample.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/regist")
  public MemberResult registMember(@Valid @RequestBody MemberRegistDto registDto) {
    return memberService.registMember(registDto);
  }

  @GetMapping("")
  public void getMember() {
    System.out.println("test");
  }
}
