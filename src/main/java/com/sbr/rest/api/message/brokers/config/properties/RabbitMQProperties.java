package com.sbr.rest.api.message.brokers.config.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
@Slf4j
@Data
public class RabbitMQProperties {

    private String queueName;
    private String exchangeName;
    private String routingKey;
}
