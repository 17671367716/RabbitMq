package com.example.demo.topic.consumer;

import com.example.demo.topic.config.TopicExchangeConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
@RabbitListener(queues = TopicExchangeConfig.TOPIC_QUEUE_NAME_1)
public class TopicConsumerOne{

    @RabbitHandler
    public void process(String msg){
        System.out.println("" + TopicExchangeConfig.TOPIC_QUEUE_NAME_1 + " : " + msg);
    }

}
