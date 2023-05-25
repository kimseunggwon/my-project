package com.example.demo.service;

import com.example.demo.memoryRepository.MemoryMemberRepository;
import com.example.demo.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemoryMemberRepository memoryMemberRepository;

    public Member login(String loginId, String password) {

        return memoryMemberRepository.findByLoginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }

}
