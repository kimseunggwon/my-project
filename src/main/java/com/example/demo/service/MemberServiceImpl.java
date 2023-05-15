package com.example.demo.service;


import com.example.demo.mapper.MemberRepository;
import com.example.demo.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Optional<Member> findMemberById(Long id) {
        return memberRepository.findById(id);
    }
    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
    @Override
    public void updateMember(Member member) {
        memberRepository.update(member);
    }
    @Override
    public void deleteMember(Long id) {
        memberRepository.delete(id);
    }
    @Override
    public List<Member> getMember() {
        return memberRepository.getMember();
    }

}
