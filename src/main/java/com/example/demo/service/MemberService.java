package com.example.demo.service;

import com.example.demo.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    void saveMember(Member member);
    Optional<Member> findMemberById(Long id);
    List<Member> findAllMembers();
    void updateMember(Member member);
    void deleteMember(Long id);
    List<Member> getMember();
}
