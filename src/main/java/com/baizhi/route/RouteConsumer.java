package com.baizhi.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component

public class RouteConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "direct",type = "direct"),
                    key = {"info","error","warn"}
            )
    })
    public void work1(String message){
        System.out.println("message1"+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "direct",type = "direct"),
                    key = {"error"}
            )
    })
    public void work2(String message){
        System.out.println("message2"+message);
    }
}
