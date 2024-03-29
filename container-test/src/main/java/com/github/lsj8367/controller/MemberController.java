package com.github.lsj8367.controller;

import com.github.lsj8367.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public String signUp() {
        memberService.save();
        return "ok";
    }

    @GetMapping
    public ResponseEntity<?> hi() {
        return ResponseEntity.ok(memberService.get());
    }

}
