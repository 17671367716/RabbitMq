package com.example.demo.direct.controller;

import com.example.demo.direct.product.DirectProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/direct")
public class DirectController{

    @Autowired
    private DirectProduct product;

    @GetMapping("/test")
    public void topicTest(){
        product.send_1();
        product.send_2();
        product.send_3();
    }
}
