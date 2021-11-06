package com.yafan.demo.controller;


import com.yafan.demo.rocketmq.Consumer;
import com.yafan.demo.rocketmq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mq")
public class rocketmqConctroller {

    @Autowired
    Producer producer;
    @Autowired
    Consumer consumer;

    @GetMapping(value = "/testmq/{topic}")
    public void testMq(@PathVariable String topic) {
        producer.defaultMQProducer(topic);
    }

    @GetMapping(value = "/consume/{topic}")
    public void tess(@PathVariable String topic){
        consumer.defaultMQPushConsumer(topic);
    }
}
