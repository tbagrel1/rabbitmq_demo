package com.tbagrel1.sdis.rabbitmq_demo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("workQueue")
@Configuration
public class WorkQueueConfig {
    @Bean
    public Queue tasks() {
        return new Queue("tasks");
    }

    @Profile("receiver")
    private static class ReceiverConfig {
        @Bean
        public WorkQueueReceiver receiver1() {
            return new WorkQueueReceiver(1);
        }

        @Bean
        public WorkQueueReceiver receiver2() {
            return new WorkQueueReceiver(2);
        }
    }

    @Profile("sender")
    @Bean
    public WorkQueueSender sender() {
        return new WorkQueueSender();
    }
}
