package com.tbagrel1.sdis.rabbitmq_demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

@RabbitListener(queues = "tasks")
public class WorkQueueReceiver {
    private final int id;

    public WorkQueueReceiver(int id) {
        this.id = id;
    }

    @RabbitHandler
    public void receive(String message) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.printf("[<-] %d: '%s'%n", id, message);
        doWork(message);
        watch.stop();
        System.out.printf("     %d: Done in %d ms%n", id, watch.getTotalTimeMillis());
    }

    private void doWork(String task) throws InterruptedException {
        for (char c: task.toCharArray()) {
            if (c == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
