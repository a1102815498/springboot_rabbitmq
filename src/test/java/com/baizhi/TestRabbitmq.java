package com.baizhi;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRabbitmq {
    //注入mq模板对象
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void fanout(){
        rabbitTemplate.convertAndSend("logs","","fanout模型");
    }
    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }
    @Test
    public void testWork(){
        for (int i = 0; i < 10; i++) {

        rabbitTemplate.convertAndSend("work","work模型");
        }
    }


    @Test
    public void route(){
        rabbitTemplate.convertAndSend("direct","error","info相关的信息");
    }
@Test
    public void topic(){
        rabbitTemplate.convertAndSend("topics","product.save","user.save的消息");
    }
}
