package com.example.demo.rabbitMQ.fanout.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitMqConfig {

    @Bean
    public FanoutExchange fanoutExchange_1() { return new FanoutExchange(FanoutExchangeConfig.FANOUT_EXCHANGE_NAME_1); }

    @Bean
    public FanoutExchange fanoutExchange_2() {
        return new FanoutExchange(FanoutExchangeConfig.FANOUT_EXCHANGE_NAME_2);
    }


    @Bean
    public Queue fanoutQueue_1() {
        return new Queue(FanoutExchangeConfig.FANOUT_QUEUE_NAME_1);
    }

    @Bean
    public Queue fanoutQueue_2() {
        return new Queue(FanoutExchangeConfig.FANOUT_QUEUE_NAME_2);
    }

    @Bean
    public Binding fanoutMessage_1(){
        return BindingBuilder.bind(fanoutQueue_1()).to(fanoutExchange_1());
    }

    @Bean
    public Binding fanoutMessage_2(){
        return BindingBuilder.bind(fanoutQueue_2()).to(fanoutExchange_1());
    }

    @Bean
    public Binding fanoutMessage_3(){
        return BindingBuilder.bind(fanoutQueue_1()).to(fanoutExchange_2());
    }

    @Bean
    public Binding fanoutMessage_4(){
        return BindingBuilder.bind(fanoutQueue_2()).to(fanoutExchange_2());
    }
}
