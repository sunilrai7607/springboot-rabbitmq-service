package com.sbr.rest.api.message.brokers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private String orderID;
    private String orderName;
    private Date creationDate;
    private Integer quantity;
}
