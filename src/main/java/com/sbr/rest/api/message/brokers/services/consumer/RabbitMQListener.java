package com.sbr.rest.api.message.brokers.services.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQListener {

    @RabbitListener(queues = "${rabbitmq.queueName}")
    public void messageListener(byte[] message) {
        String msg = new String(message);
        log.info("Order Received Message : {} ", msg);
    }
}
