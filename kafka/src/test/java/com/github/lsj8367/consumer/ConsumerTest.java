package com.github.lsj8367.consumer;

import static org.assertj.core.api.Assertions.assertThat;
import com.github.lsj8367.message.PushReq;
import com.github.lsj8367.producer.KafkaConsumer;
import com.github.lsj8367.producer.KafkaProducer;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class ConsumerTest {

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private KafkaProducer producer;

    @Value("${test.topic}")
    private String topic;

    @Test
    void givenKafkaDockerContainer_whenSendingWithSimpleProducer_thenMessageReceived()
        throws Exception {
        producer.send(topic, new PushReq("hi"));
        consumer.getLatch().await(10, TimeUnit.SECONDS);
        System.out.println(consumer);
    }

}
