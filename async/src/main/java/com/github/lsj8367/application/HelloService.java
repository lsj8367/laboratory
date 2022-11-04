package com.github.lsj8367.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloService {

    @Async("threadPoolTaskExecutor")
    public void printAsync() {
        try {
            Thread.sleep(5000);
            log.info(Thread.currentThread().getName());
            log.info("hello service print!!!");
        } catch (InterruptedException e) {
            log.error("error : {}", e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
