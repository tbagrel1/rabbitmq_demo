package com.tbagrel1.sdis.rabbitmq_demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "directMessages")
public class DirectMessageReceiver {
    @RabbitHandler
    public void receive(String message) {
        System.out.printf("[<-] '%s'%n", message);
    }
}
