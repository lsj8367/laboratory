package com.github.lsj8367.configuration;

import com.github.lsj8367.message.MessageReq;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties.AckMode;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class ConsumerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String servers;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MessageReq> containerFactory() {
        final ConcurrentKafkaListenerContainerFactory<String, MessageReq> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setAckMode(AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

    private ConsumerFactory<String, MessageReq> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
            configProperties(), new StringDeserializer(),
            new JsonDeserializer<>(MessageReq.class, false)
        );
    }

    private Map<String, Object> configProperties() {
        return Map.of(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers,
            ConsumerConfig.GROUP_ID_CONFIG, groupId,
            JsonDeserializer.TRUSTED_PACKAGES, "*"
        );
    }

}
