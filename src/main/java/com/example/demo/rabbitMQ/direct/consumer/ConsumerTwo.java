package com.example.demo.rabbitMQ.direct.consumer;

import com.example.demo.rabbitMQ.direct.config.DirectExchangeConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = DirectExchangeConfig.DIRECT_QUEUE_NAME_2)
public class ConsumerTwo {
    @RabbitHandler
    public void process(String msg){
        System.out.println("" + DirectExchangeConfig.DIRECT_QUEUE_NAME_2 + " : " + msg);
    }
}
