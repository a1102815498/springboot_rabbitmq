package com.baizhi.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//默认持久化
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloConsumer {

    @RabbitHandler
    public void recive(String message){
        System.out.println(message);

    }

}
