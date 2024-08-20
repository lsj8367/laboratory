package com.github.lsj8367.service;

import com.github.lsj8367.entity.Member;
import com.github.lsj8367.infra.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save() {
        memberRepository.save(new Member(1L, "홍길동"));
    }

    @Transactional
    public void saveAndException() {
        memberRepository.save(new Member(null, "홍길동"));
        throw new RuntimeException();
    }

    public Member get() {
        return memberRepository.findById(1L).orElseThrow();
    }

    public int allSize() {
        return memberRepository.findAll().size();
    }

}
