package com.example.demo.direct.consumer;

import com.example.demo.direct.config.DirectExchangeConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
@RabbitListener(queues = DirectExchangeConfig.DIRECT_QUEUE_NAME_1)
public class ConsumerOne {

    @RabbitHandler
    public void process(String msg){
        System.out.println("" + DirectExchangeConfig.DIRECT_QUEUE_NAME_1 + " : " + msg);
    }

}
