package com.uj.jwtsample.member.controller;

import static com.uj.jwtsample.common.constant.CommonConstant.ACCESS_TOKEN_HEADER_NAME;

import com.uj.jwtsample.member.model.Member.MemberRegistDto;
import com.uj.jwtsample.member.model.Member.MemberResult;
import com.uj.jwtsample.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
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

  /** 회원 가입 */
  @PostMapping("/regist")
  public MemberResult registMember(@Valid @RequestBody MemberRegistDto registDto) {
    return memberService.registMember(registDto);
  }

  /** 내 정보 조회 */
  @GetMapping
  public MemberResult getMember(HttpServletRequest request) {
    return memberService.getMember(request.getHeader(ACCESS_TOKEN_HEADER_NAME));
  }
}
