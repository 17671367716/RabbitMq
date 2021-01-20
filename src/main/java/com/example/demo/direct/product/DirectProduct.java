package com.example.demo.direct.product;

import com.example.demo.direct.config.DirectExchangeConfig;
import com.example.demo.topic.config.TopicExchangeConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 消息队列发送类
 * @author Administrator
 */
@Component
public class DirectProduct {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send_1(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
        for(int i = 0;i<20;i++){
            String date = sdf.format(new Date());
            System.out.println("生产者 1 ：" + date);
            rabbitTemplate.convertAndSend(DirectExchangeConfig.DIRECT_EXCHANGE_NAME, DirectExchangeConfig.DIRECT_ROUTINGKEY_MESSAGE_1,date);
        }
    }

    public void send_2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0;i<20;i++){
            String date = sdf.format(new Date());
            System.out.println("生产者 2 ：" + date);
            rabbitTemplate.convertAndSend(DirectExchangeConfig.DIRECT_EXCHANGE_NAME, DirectExchangeConfig.DIRECT_ROUTINGKEY_MESSAGE_2,date);
        }
    }

    public void send_3(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        for(int i = 0;i<20;i++){
            String date = sdf.format(new Date());
            System.out.println("生产者 3 ：" + date);
            rabbitTemplate.convertAndSend(DirectExchangeConfig.DIRECT_EXCHANGE_NAME, DirectExchangeConfig.DIRECT_ROUTINGKEY_MESSAGE_3,date);
        }
    }

}
