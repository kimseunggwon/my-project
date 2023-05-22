package com.example.demo.mapper;


import com.example.demo.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    void save(Member member);

    void update(Member member);

    void delete(long id);

    Member findById(long id);

    List<Member> findAll();



}
