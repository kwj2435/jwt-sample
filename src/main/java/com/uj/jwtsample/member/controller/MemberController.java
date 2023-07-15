package com.uj.jwtsample.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

  @PostMapping("/regist")
  public void registMember() {
    System.out.println("test");
  }

  @GetMapping("/regist")
  public void getMember() {
    System.out.println("test");
  }
}
