package com.example.demo.fanout.consumer;

import com.example.demo.fanout.config.FanoutExchangeConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = FanoutExchangeConfig.FANOUT_QUEUE_NAME_2)
public class FanoutTwo {

    @RabbitHandler
    public void process(String msg){
        System.out.println("" + FanoutExchangeConfig.FANOUT_QUEUE_NAME_2 + " : " + msg);
    }

}
