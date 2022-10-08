package com.github.lsj8367.consumer;

import com.github.lsj8367.message.MessageReq;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class AckConsumer {

    @KafkaListener(topics = "topic", properties = {
        "spring.kafka.consumer.properties.spring.json.type.mapping=com.github.lsj8367.MessageReq"
    })
    public void consumeSomething(final MessageReq req, Acknowledgment acknowledgment) {

    }


}
