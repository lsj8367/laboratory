package com.github.lsj8367.application;

import com.github.lsj8367.message.MessageReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PushService {

    public void sendPush(final MessageReq req, Acknowledgment acknowledgment) {
        try {
            log.info("push Success : {}", req);
        } finally {
            acknowledgment.acknowledge();
        }
    }

}
