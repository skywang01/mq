package com.sky.mq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {


    @Value("${topicExchange}")
    private String topicExchange;

    @Value("#.rount.*")
    private String deadLetter;


    /**
     * 定义一个类型的队列通道
     * @return
     */
    @Bean
    public Queue deadLetterQueue() {
        Queue queue = new Queue(deadLetter);
        return queue;
    }


    /**
     * 定义一个topic类型的交换器
     * @return
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchange);
    }


    /**
     * 交换器与队列绑定
     */
    @Bean
    Binding bindingExchangeDeadLetterMessage() {
        return BindingBuilder.bind(deadLetterQueue()).to(exchange()).with(deadLetter);
    }

}