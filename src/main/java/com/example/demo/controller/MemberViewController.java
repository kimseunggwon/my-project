package com.example.demo.controller;

import com.example.demo.memoryRepository.MemoryMemberRepository;
import com.example.demo.model.LoginForm;
import com.example.demo.model.Member;
import com.example.demo.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberViewController {


    private final MemoryMemberRepository memoryMemberRepository;
    private final LoginService loginService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    /** 회원가입
     */
    @GetMapping("/add")
    public String addMember(@ModelAttribute("member") Member member){
        log.info("컨트롤러 진입");
        return "member/addMemberForm";
    }

    @PostMapping("/add")
    public String saveMember(@ModelAttribute("member") Member member, Model model ,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("Validation errors occurred: {}",bindingResult.getAllErrors());
        }

        model.addAttribute("registrationCompleted" ,true);
        memoryMemberRepository.save(member);
        log.info("Member save : {} ", member);
        return "member/addMemberForm";
    }

    /** 목록 보기
     */
    @GetMapping("/memberList")
    public String memberList(Model model){
        List<Member> members = memoryMemberRepository.findAll();
        model.addAttribute("member",members);
        return "member/memberList";
    }

    /** 상세 목록 보기
     */
    @GetMapping("/{memberId}")
    public String Member(@PathVariable long memberId,Model model){
        Member member = memoryMemberRepository.findById(memberId);
        model.addAttribute("member",member);
        return "member/memberListDetail";
    }

    /** 로그인
     */
    @GetMapping("/login")
    public String login1(@ModelAttribute("member") Member member) {

        return "member/memberLogin";
    }

    @PostMapping("/login")
    public String login2(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "member/memberLogin";
        }

        Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
        log.info("form.getLoginId: {}", loginForm.getLoginId());
        log.info("form.getPassword: {}", loginForm.getPassword());
        log.info("loginMember: {}", loginMember);

        if (loginMember == null) {
            bindingResult.reject("fail", "아이디, 비밀번호가 맞지 않습니다.");
            return "member/memberLogin";
        }

        return "redirect:/member/memberList";
    }


    // 페이지네이션

    // 회원가입

    // 로그인 


}
