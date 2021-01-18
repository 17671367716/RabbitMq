package com.example.demo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class SendController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/send")
    public String send(){
        String times = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i=0;i<20;i++){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            String data = sdf.format(new Date());
            amqpTemplate.convertAndSend("test-q1"," 第" + i+ "次发送，时间 ：" + data);
            amqpTemplate.convertAndSend("test-q2"," 第" + i+ "次发送，时间 ：" + data);
            times =times + "now Date :" + data + "<br>" ;

        }
        return times;
    }
}
