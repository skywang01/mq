package com.sky.mq.producer.api;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author sky
 * @data 2018/12/11 11:52 AM
 */
@RestController
public class RmqConsumerApi {


    @RabbitHandler
    @RabbitListener(queues = "#.rount.*")
    public  void  consumer(@Payload String  msg,
                           @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
                           Channel channel) throws IOException {
        System.out.println("接受到:"+msg);
        channel.basicAck(deliveryTag,true);
    }
}
