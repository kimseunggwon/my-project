package com.example.demo.mapper;


import com.example.demo.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    void save(Member member);

    Optional<Member> findById(Long id);

    List<Member> findAll();

    void update(Member member);

    void delete(Long id);

    List<Member> getMember();

}
