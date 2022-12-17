package com.github.lsj8367.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record SlowService() {

    public static final int FIRST_NUMBER = 1;

    // 이 자원을 공통으로 아래의 call 2, 3, 4를 수행한다.
    public int first() {
        return FIRST_NUMBER;
    }

    public int call2(final int number) throws InterruptedException {
        log.info("call2 number : {}", number);
        Thread.sleep(5000L);
        return 2;
    }

    public int call3(final int number) throws InterruptedException {
        log.info("call3 number : {}", number);
        Thread.sleep(3000L);
        return 3;
    }

    public int call4(final int number) throws InterruptedException {
        log.info("call4 number : {}", number);
        Thread.sleep(4000L);
        return 4;
    }
}
