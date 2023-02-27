package com.github.lsj8367.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionParentService {

    private final MemberService memberService;
    private final TransactionErrorService transactionErrorService;

    @Transactional
    public int size() {
        transactionErrorService.throwExceptionLog();
        return memberService.allSize();
    }

}
