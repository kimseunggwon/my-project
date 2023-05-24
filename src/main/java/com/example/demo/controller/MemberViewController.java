package com.example.demo.controller;

import com.example.demo.memoryRepository.MemoryMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/test")
public class MemberViewController {



    @GetMapping("/home")
    public String home() {
        return "home";
    }



    // 페이지네이션

    // 회원가입

    // 로그인 


}
