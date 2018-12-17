package com.sky.mq.producer.api;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sky
 * @data 2018/12/11 11:21 AM
 * 生产者
 */
@RestController
public class RmqProducerApi {


    @Autowired
    private RabbitTemplate rabbitTemplate ;


    @Value("${topicExchange}")
    private  String topicExchange ;


    @RequestMapping("/produce")
    public  void  produce(@RequestParam  String  rountingkey){
        String  msg ="produce 生产了一件工艺品";
        System.out.println("who:"+msg);
        rabbitTemplate.convertAndSend(topicExchange,rountingkey,msg);
    }





}
