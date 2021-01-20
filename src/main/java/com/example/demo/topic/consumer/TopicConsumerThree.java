package com.example.demo.topic.consumer;

import com.example.demo.topic.config.TopicExchangeConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = TopicExchangeConfig.TOPIC_QUEUE_NAME_3)
public class TopicConsumerThree {
    @RabbitHandler
    public void process(String msg){
        System.out.println("" + TopicExchangeConfig.TOPIC_QUEUE_NAME_3 + " : " + msg);
    }
}
