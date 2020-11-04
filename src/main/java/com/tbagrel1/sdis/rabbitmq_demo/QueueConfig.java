package com.tbagrel1.sdis.rabbitmq_demo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class QueueConfig {
    @Bean
    public Queue directMessages() {
        return new Queue("directMessages");
    }

    @Profile("receiver")
    @Bean
    public DirectMessageReceiver receiver() {
        return new DirectMessageReceiver();
    }

    @Profile("sender")
    @Bean
    public DirectMessageSender sender() {
        return new DirectMessageSender();
    }
}
