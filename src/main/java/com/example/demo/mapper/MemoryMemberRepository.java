package com.example.demo.mapper;

import com.example.demo.model.Member;

import java.util.List;

public interface MemoryMemberRepository {

    Member save(Member member);

    void update(Member member,long id);

    void delete(long id);

    Member findById(long id);

    List<Member> findAll();



}
