package com.example.demo.service;

import com.example.demo.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    void saveMember(Member member);

    void update(Member member,long id);

    void delete(long id);

    Member findById(long id);
    List<Member> findAll();
}
