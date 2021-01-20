package com.example.demo.topic.consumer;

import com.example.demo.topic.config.TopicExchangeConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = TopicExchangeConfig.TOPIC_QUEUE_NAME_2)
public class TopicConsumerTwo {
    @RabbitHandler
    public void process(String msg){
        System.out.println("" + TopicExchangeConfig.TOPIC_QUEUE_NAME_2 + " : " + msg);
    }
}
