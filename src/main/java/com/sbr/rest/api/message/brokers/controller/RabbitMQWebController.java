package com.sbr.rest.api.message.brokers.controller;

import com.sbr.rest.api.message.brokers.model.Order;
import com.sbr.rest.api.message.brokers.model.OrderStatus;
import com.sbr.rest.api.message.brokers.services.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/messages", produces = MediaType.APPLICATION_JSON_VALUE)
public class RabbitMQWebController {

    private final RabbitMQService rabbitMQService;

    @Autowired
    public RabbitMQWebController(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    @GetMapping(value = "/producer")
    public ResponseEntity<OrderStatus> produceMessage(@RequestParam("item") String item, @RequestParam(value = "quantity") Integer quantity) {
        Order order = new Order();
        order.setOrderID(UUID.randomUUID().toString());
        order.setOrderName(item);
        order.setQuantity(quantity);
        return ResponseEntity.ok(rabbitMQService.sendMessage(order));
    }
}
