package com.tbagrel1.sdis.rabbitmq_demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

public class PubSubReceiver {

    @RabbitListener(queues = "#{anonymousQueue1.name}")
    public void receive1(String message) throws InterruptedException {
        receive(message, 1);
    }

    @RabbitListener(queues = "#{anonymousQueue2.name}")
    public void receive2(String message) throws InterruptedException {
        receive(message, 2);
    }

    public void receive(String message, int id) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.printf("[<-] %d: '%s'%n", id, message);
        doWork(message);
        watch.stop();
        System.out.printf("     %d: Done '%s' in %d ms%n", id, message, watch.getTotalTimeMillis());
    }

    private void doWork(String task) throws InterruptedException {
        for (char c: task.toCharArray()) {
            if (c == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
