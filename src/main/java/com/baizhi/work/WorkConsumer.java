package com.baizhi.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component

public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue(name = "work"))
    public void work1(String message){
        System.out.println("message1:"+message);

    }
    @RabbitListener(queuesToDeclare = @Queue(name = "work"))
    public void work2(String message){
        System.out.println("message2:"+message);

    }

}
