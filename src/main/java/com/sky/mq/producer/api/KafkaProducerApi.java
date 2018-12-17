package com.sky.mq.producer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sky
 * @data 2018/12/14 3:07 PM
 */
@RestController
public class KafkaProducerApi {



    @Autowired
    private KafkaTemplate<String,String>  kafkaTemplate ;


    @RequestMapping("/kafka/producer")
    public  void  sendMsg(@RequestParam  String  message){
        kafkaTemplate.send("wkk",message);
    }
}
