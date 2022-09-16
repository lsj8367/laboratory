package com.github.lsj8367.producer;

import com.github.lsj8367.message.MessageReq;
import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private CountDownLatch latch = new CountDownLatch(1);

    private String payload = null;

    @KafkaListener(topics = "${test.topic}")
    public void receive(MessageReq messageReq) {
        LOGGER.info("received payload='{}'", messageReq);
        setPayload(messageReq.name());
        latch.countDown();
    }

    private void setPayload(final String toString) {
        this.payload = toString;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public String getPayload() {
        return payload;
    }

}
