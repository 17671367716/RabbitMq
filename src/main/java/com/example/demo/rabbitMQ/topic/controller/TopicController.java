package com.example.demo.rabbitMQ.topic.controller;

import com.example.demo.rabbitMQ.topic.product.TopicProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicProduct topicProduct;

    @GetMapping("/test")
    public void topicTest(){
        topicProduct.send_1();
//        topicProduct.send_2();
//        topicProduct.send_3();
    }

}
