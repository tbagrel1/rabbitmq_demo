package com.tbagrel1.sdis.rabbitmq_demo;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("pubSub")
@Configuration
public class PubSubConfig {
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("pubSubFanout");
    }

    @Profile("receiver")
    private static class ReceiverConfig {
        @Bean
        public Queue anonymousQueue1() {
            return new AnonymousQueue();
        }

        @Bean
        public Queue anonymousQueue2() {
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1(FanoutExchange fanout, Queue anonymousQueue1) {
            return BindingBuilder.bind(anonymousQueue1).to(fanout);
        }

        @Bean
        public Binding binding2(FanoutExchange fanout, Queue anonymousQueue2) {
            return BindingBuilder.bind(anonymousQueue2).to(fanout);
        }

        @Bean
        public PubSubReceiver receiver() {
            return new PubSubReceiver();
        }
    }

    @Profile("sender")
    @Bean
    public PubSubSender sender() {
        return new PubSubSender();
    }
}
