package com.example.demo.memoryRepository;


import com.example.demo.mapper.MemberMapper;
import com.example.demo.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class MemoryMemberRepository {

    private static final Map<Long,Member> map = new HashMap<>();
    private static long quantity = 0;


    public Member save(Member member) {
        member.setId(++quantity);
        map.put(member.getId(), member);
        return member;
    }


    public void update(Member member, long id) {
        Member existMember = findById(id);
        if (existMember != null){
            existMember.setName(member.getName());
            existMember.setAge(member.getAge());
            existMember.setPassword(member.getPassword());

            map.put(id,existMember);
        }
    }


    public void delete(long id) {
        map.remove(id);
    }


    public Member findById(long id) {
        return map.get(id);
    }


    public List<Member> findAll() {
        return new ArrayList<>(map.values());
    }

    public Optional<Member> findByLoginId(String loginId) {

        return findAll().stream()
                .filter(member -> member.getLoginId().equals(loginId))
                .findFirst();
    }


}
