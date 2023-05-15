package com.example.demo.mapper;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public class MemberRepository implements MemberMapper{

    private MemberMapper memberMapper;

    public MemberRepository(@Lazy MemberMapper memberMapper){
        memberMapper = memberMapper;
    }

    /**  스프링 빈 순환참조 에러
     *  @ RequiredArgsConstructor
     *   private final  MemberMapper memberMapper;
     */


    @Override
    public void save(Member member) {
        memberMapper.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberMapper.findById(id);
    }

    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public void update(Member member) {
        memberMapper.update(member);
    }

    @Override
    public void delete(Long id) {
        memberMapper.delete(id);
    }

    @Override
    public List<Member> getMember() {
        return memberMapper.getMember();
    }
}
