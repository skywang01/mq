package com.sky.mq.producer.api;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sky
 * @data 2018/12/14 3:07 PM
 */
@RestController
public class KafkaConsumerApi {


    @KafkaListener(topics = {"wkk"})
    public  void  consumerMsg(ConsumerRecord msg){
        System.out.println("接受到的消息："+msg);
    }
}
