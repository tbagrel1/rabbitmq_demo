package com.tbagrel1.sdis.rabbitmq_demo;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

public class PubSubSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange fanout;

    AtomicInteger dots = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Task[");
        builder.append(count.getAndIncrement());
        builder.append("]: ");
        if (dots.incrementAndGet() == 4) {
            dots.set(1);
        }

        for (int i = 0; i < dots.get(); ++i) {
            builder.append('.');
        }
        String message = builder.toString();
        template.convertAndSend(fanout.getName(), "", message);
        System.out.printf("[->] Sent '%s'%n", message);
    }
}
