package com.tbagrel1.sdis.rabbitmq_demo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class DirectMessageSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    private int count = 0;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = String.format("Sender message no. %d", count++);
        this.template.convertAndSend(queue.getName(), message);
        System.out.printf("[->] '%s'%n", message);
    }
}
