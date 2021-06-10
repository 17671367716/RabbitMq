package com.example.demo.rabbitMQ.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitMqConfig {

    @Bean
    public TopicExchange topicExchange() {

//        new TopicExchange(ExchangeConfig.TOPIC_EXCHANGE_NAME_1,true,false);
//        durable 默认为 true ,autoDelete 默认为 false
        return new TopicExchange(TopicExchangeConfig.TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public Queue topicQueue_1() {
        return new Queue(TopicExchangeConfig.TOPIC_QUEUE_NAME_1, true, false, false);
    }

    @Bean
    public Queue topicQueue_2() {
        return new Queue(TopicExchangeConfig.TOPIC_QUEUE_NAME_2);
    }

    @Bean
    public Queue topicQueue_3() { return new Queue(TopicExchangeConfig.TOPIC_QUEUE_NAME_3);}

    @Bean
    public Queue topicQueue_4() { return new Queue(TopicExchangeConfig.TOPIC_QUEUE_NAME_4);}

    @Bean
    public Binding topicMessage_1(){
        return BindingBuilder.bind(topicQueue_1()).to(topicExchange()).with(TopicExchangeConfig.T1);
    }

    @Bean
    public Binding topicMessage_2(){
        return BindingBuilder.bind(topicQueue_2()).to(topicExchange()).with(TopicExchangeConfig.T2);

    }
    @Bean
    public Binding topicMessage_3(){
        return BindingBuilder.bind(topicQueue_3()).to(topicExchange()).with(TopicExchangeConfig.T3);
    }

    @Bean
    public Binding topicMessage_4(){
        return BindingBuilder.bind(topicQueue_4()).to(topicExchange()).with(TopicExchangeConfig.T4);
    }

}
