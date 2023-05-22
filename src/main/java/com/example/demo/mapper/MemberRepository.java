
package com.example.demo.mapper;

import com.example.demo.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class MemberRepository implements MemberMapper{

    private final MemberMapper memberMapper;


    @Override
    public void save(Member member) {
        memberMapper.save(member);
    }

    @Override
    public void update(Member member) {
        memberMapper.update(member);
    }

    @Override
    public void delete(long id) {
        memberMapper.delete(id);
    }

    @Override
    public Member findById(long id) {
        return memberMapper.findById(id);
    }

    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }
}

