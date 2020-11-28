package com.sbr.rest.api.message.brokers.services;

import com.sbr.rest.api.message.brokers.model.Order;
import com.sbr.rest.api.message.brokers.model.OrderStatus;
import com.sbr.rest.api.message.brokers.services.producer.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQService {

    private final MessageProducer messageProducer;

    @Autowired
    public RabbitMQService(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public OrderStatus sendMessage(Order order) {
        OrderStatus orderStatus = new OrderStatus(order, "Order Created Successfully");
        messageProducer.sendMessage(order);
        return orderStatus;

    }
}
