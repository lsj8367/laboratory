package com.github.lsj8367.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionErrorService {

    private final MemberService memberService;

    @Transactional
    public void throwExceptionLog() {

        try {
            memberService.saveAndException();
        } catch (RuntimeException e) {
            log.error("error : {}", e.getMessage());
        }

        System.out.println("끝");
    }

}
