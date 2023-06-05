package com.example.demo.service;

import com.example.demo.memoryRepository.MemoryMemberRepository;
import com.example.demo.model.Member;
import com.example.demo.model.enumError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final MemoryMemberRepository memoryMemberRepository;
    //private Set<Long> loggedInMemberIds = new HashSet<>();


    public Member login(String loginId, String password) {
        Map<String, Object> resultMap = new HashMap<>();

        if (memoryMemberRepository.findByLoginId(loginId).equals(loginId)){
            resultMap.put("status",enumError.ALREADY_LOGGED_IN);
            log.info("resultMap: {}",resultMap);
        }

        return memoryMemberRepository.findByLoginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);

    }

}
