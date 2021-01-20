package com.example.demo.topic.product;

import com.example.demo.topic.config.TopicExchangeConfig;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 消息队列发送类
 * @author Administrator
 */
@Component
public class TopicProduct implements BeanPostProcessor {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send_1(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
        for(int i = 0;i<10;i++){
            String date = sdf.format(new Date());
            System.out.println("生产者 1 ：" + date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, "a.b",date);
        }
        for(int i = 0;i<10;i++){
            String date = sdf.format(new Date());
            System.out.println("生产者 2 ：" + date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, "a.c",date);
        }
    }

    public void send_2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0;i<20;i++){
            String date = sdf.format(new Date());
            System.out.println("生产者 2 ：" + date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, TopicExchangeConfig.TOPIC_ROUTINGKEY_MESSAGES + ".test",date);
        }
    }

    public void send_3(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        for(int i = 0;i<20;i++){
            String date = sdf.format(new Date());
            System.out.println("生产者 3 ：" + date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, TopicExchangeConfig.TOPIC_ROUTINGKEY_MESSAGES_,date);
        }
    }
}
