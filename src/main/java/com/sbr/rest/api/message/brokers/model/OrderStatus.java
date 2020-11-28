package com.sbr.rest.api.message.brokers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OrderStatus implements Serializable {

    private Order order;
    private String status;
}
