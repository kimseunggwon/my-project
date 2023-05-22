package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import com.example.demo.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    /**  home
     */
    @GetMapping(value = "/helloworld")
    public String helloWorld() {
        return "hello world";
    }

    /** json 형식 insert
     */
    @PostMapping("/memberAdd")
    public Member memberAdd(@RequestBody Member member) {
        memberService.saveMember(member);
        return member;
    }

    /** 조회
     */
    @GetMapping("/getMemberAll")
    public List<Member> getMember(Member member) {
        log.info("모델 컨트롤러 진입");
        return memberService.findAll();
    }

    @GetMapping("/getMember/{id}")
    public Member getMemberById(@PathVariable long id) {
        log.info("모델 컨트롤러 진입");
        return memberService.findById(id);
    }

    @PutMapping("/memberUpdate/{id}")
    public List<Member> memberUpdate(@PathVariable long id,@RequestBody Member member) {
        memberService.update(member,id);
        return memberService.findAll();
    }

    @DeleteMapping("/memberDelete/{id}")
    public List<Member> memberDelete(@PathVariable long id){
        memberService.delete(id);

        return memberService.findAll();
    }

}
