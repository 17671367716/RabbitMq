package com.example.demo.fanout.controller;

import com.example.demo.direct.config.DirectExchangeConfig;
import com.example.demo.direct.product.DirectProduct;
import com.example.demo.fanout.config.FanoutExchangeConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/fanout")
public class FanoutController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public void send(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
        for(int i = 0;i<10;i++){
            String date = sdf.format(new Date());
            System.out.println("生产者 1 ：" + date);
            rabbitTemplate.convertAndSend(FanoutExchangeConfig.FANOUT_EXCHANGE_NAME_1, "",date);
            rabbitTemplate.convertAndSend(FanoutExchangeConfig.FANOUT_EXCHANGE_NAME_2,"",date);
        }
    }
}
