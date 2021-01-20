package com.example.demo.direct.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectRabbitMqConfig implements BeanPostProcessor {

    @Bean
    public DirectExchange directExchange() {

//        new DirectExchange(ExchangeConfig.TOPIC_EXCHANGE_NAME_1,true,false);
//        durable 默认为 true ,autoDelete 默认为 false
        return new DirectExchange(DirectExchangeConfig.DIRECT_EXCHANGE_NAME);
    }

    @Bean
    public Queue directQueue_1() {
//        new Queue(TopicExchangeConfig.TOPIC_QUEUE_NAME_1, true, false, false)  默认是这个
        return new Queue(DirectExchangeConfig.DIRECT_QUEUE_NAME_1);
    }

    @Bean
    public Queue directQueue_2() {
        return new Queue(DirectExchangeConfig.DIRECT_QUEUE_NAME_2);
    }

    @Bean
    public Queue directQueue_3() {
        return new Queue(DirectExchangeConfig.DIRECT_QUEUE_NAME_3);
    }

    @Bean
    public Binding directMessage_1(){
        return BindingBuilder.bind(directQueue_1()).to(directExchange()).with(DirectExchangeConfig.DIRECT_ROUTINGKEY_MESSAGE_1);
    }

    @Bean
    public Binding directMessage_2(){
        return BindingBuilder.bind(directQueue_2()).to(directExchange()).with(DirectExchangeConfig.DIRECT_ROUTINGKEY_MESSAGE_2);
    }

    @Bean
    public Binding directMessage_3(){
        return BindingBuilder.bind(directQueue_3()).to(directExchange()).with(DirectExchangeConfig.DIRECT_ROUTINGKEY_MESSAGE_3);
    }

}
