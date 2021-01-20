package com.example.demo.topic.controller;

import com.example.demo.topic.consumer.TopicConsumerOne;
import com.example.demo.topic.consumer.TopicConsumerThree;
import com.example.demo.topic.consumer.TopicConsumerTwo;
import com.example.demo.topic.product.TopicProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
