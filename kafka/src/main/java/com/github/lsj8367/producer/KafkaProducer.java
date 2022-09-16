package com.github.lsj8367.producer;

import com.github.lsj8367.message.PushReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public record KafkaProducer(KafkaTemplate<String, PushReq> kafkaTemplate) {

    public void send(String topic, PushReq pushReq) {
        log.info("sending payload='{}' to topic='{}'", pushReq, topic);
        kafkaTemplate.send(topic, pushReq);
    }
}
