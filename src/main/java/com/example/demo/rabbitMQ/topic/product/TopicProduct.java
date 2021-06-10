package com.example.demo.rabbitMQ.topic.product;

import com.example.demo.rabbitMQ.topic.config.TopicExchangeConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

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
        for(int i = 0;i<1;i++){
            String date = sdf.format(new Date());
            System.out.println("生产者 ：" + date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, "a.b.c","a.b.c : " + date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, "a.b.d","a.b.d : " + date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, "a.b","a.b :"+date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, "a.c","a.c :"+date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, "a","a : " + date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, "c","c :"+date);

            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, "b.c","b.c :"+date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, "d.b.c","d.b.c :"+date);

        }
    }

    public void send_2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0;i<20;i++){
            String date = sdf.format(new Date());
            System.out.println("生产者 2 ：" + date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, TopicExchangeConfig.T + ".test",date);
        }
    }

    public void send_3(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        for(int i = 0;i<20;i++){
            String date = sdf.format(new Date());
            System.out.println("生产者 3 ：" + date);
            rabbitTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE_NAME, TopicExchangeConfig.T,date);
        }
    }
}
