package com.sbr.rest.api.message.brokers.services.producer;

import com.sbr.rest.api.message.brokers.config.properties.RabbitMQProperties;
import com.sbr.rest.api.message.brokers.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQProperties rabbitMQProperties;

    @Autowired
    public MessageProducer(RabbitTemplate rabbitTemplate, RabbitMQProperties rabbitMQProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMQProperties = rabbitMQProperties;
    }

    public void sendMessage(Order order) {
        log.info("Routing : {} ", rabbitTemplate.getRoutingKey());
        log.info("Exchange : {} ", rabbitTemplate.getExchange());
        rabbitTemplate.convertAndSend(rabbitMQProperties.getExchangeName(), rabbitMQProperties.getRoutingKey(), order);
    }
}
