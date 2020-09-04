package com.rabbitmq.rabbitpub;

import lombok.Data;

@Data
public class SimpleMessage {
    private String name;
    private String description;
}
