package com.example.demo.service;


import com.example.demo.mapper.MemberMapper;


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
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public void update(Member member,long id) {
        memberRepository.update(member);
    }

    @Override
    public void delete(long id) {
        memberRepository.delete(id);
    }

    @Override
    public Member findById(long id) {
        return memberRepository.findById(id);
    }
}
