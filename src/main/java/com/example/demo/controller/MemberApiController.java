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
public class MemberApiController {

    private final MemberService memberService;

    /**  home
     */
    @GetMapping(value = "/helloworld")
    public String helloWorld() {
        return "hello world";
    }

    /** insert
     */
    @PostMapping("/memberAdd")
    public Member memberAdd(@RequestBody Member member) {  // RequestBody : 클라이언트 요청에서 전달 받은 데이터를 바로 사용할 수 있다.
        memberService.saveMember(member);
        return member;
    }

    /** all 조회
     */
    @GetMapping("/getMemberAll")
    public List<Member> getMember(Member member) {
        log.info("getMember 컨트롤러 진입");
        return memberService.findAll();
    }

    /** id 조회
     */
    @GetMapping("/getMember/{id}")
    public Member getMemberById(@PathVariable long id) {
        log.info("getMemberById 컨트롤러 진입");
        return memberService.findById(id);
    }

    /** update
     */
    @PutMapping("/memberUpdate/{id}")
    public List<Member> memberUpdate(@PathVariable long id,@RequestBody Member member) {
        memberService.update(member,id);
        return memberService.findAll();
    }

    /** delete
     */
    @DeleteMapping("/memberDelete/{id}")
    public List<Member> memberDelete(@PathVariable long id){
        memberService.delete(id);

        return memberService.findAll();
    }

}
