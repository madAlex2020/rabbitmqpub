package com.rabbitmq.rabbitpub;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class RabbitMQController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("name") String name, @RequestParam("desc") String desc) {
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setName(name);
        simpleMessage.setDescription(desc);
        amqpTemplate.convertAndSend("TestExchange", "testRouting", simpleMessage);
        return "Message sent to the RabbitMQ Successfully";
    }
}
