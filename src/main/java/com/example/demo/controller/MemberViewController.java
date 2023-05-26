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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        return "home";
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
  /*  @GetMapping("/{memberId}")
    public String Member(@PathVariable long memberId,Model model){
        Member member = memoryMemberRepository.findById(memberId);
        model.addAttribute("member",member);
        return "member/memberListDetail";
    }*/

    /** 로그인
     */
    @GetMapping("/login")
    public String login1(Model model) {
        Member member1 = new Member();
        model.addAttribute("member",member1);
        return "member/memberLogin";
    }

    @PostMapping("/login")
    public String login2(@Valid @ModelAttribute("member") LoginForm loginForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            return "member/memberLogin";
        }

        Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
        log.info("form.getLoginId: {}", loginForm.getLoginId());
        log.info("form.getPassword: {}", loginForm.getPassword());
        log.info("loginMember: {}", loginMember);

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디, 비밀번호가 맞지 않습니다.");
            return "member/memberLogin";
        } else if (loginForm.getLoginId() == null && loginForm.getPassword() == null) {
            bindingResult.reject("loginNull", "아이디와 비밀번호를 입력하세요.");
            return "member/memberLogin";
        }

        //맴버 여부 확인
        /*boolean memberExists = memoryMemberRepository.findById(loginMember.getId()) != null;
        if (!memberExists) {
            bindingResult.reject("fail","회원 정보가 없습니다.");
            return "member/memberLogin";
        }*/


        Optional<Member> optionalMember = Optional.ofNullable(memoryMemberRepository.findById(loginMember.getId()));
        if (optionalMember.isEmpty()) {
            bindingResult.reject("loginId", "회원 정보를 입력하세요");
            bindingResult.reject("password", "회원 정보를 입력하세요");
            return "member/memberLogin";
        }


        //로그인 성공
        Member authMember = optionalMember.get();
        redirectAttributes.addFlashAttribute("loginMember",authMember);
        redirectAttributes.addFlashAttribute("success","로그인 성공");

        return "redirect:/member/memberList";
    }


    // 페이지네이션

    // 회원가입

    // 로그인 


}
