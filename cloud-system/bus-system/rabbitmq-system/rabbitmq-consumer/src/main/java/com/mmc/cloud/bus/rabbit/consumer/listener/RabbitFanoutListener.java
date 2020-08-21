package com.mmc.cloud.bus.rabbit.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.consumer.listener
 * @desrciption:
 * @author: GW
 * @date： 2020-08-21 10:59
 * @history: (version) author date desc
 */
@Component
public class RabbitFanoutListener {

    private final Logger logger = LoggerFactory.getLogger(RabbitFanoutListener.class);

    @RabbitListener(queues = "rabbit.fanout.queue.email1")
    public void fanoutEmailA(String message){
        logger.info("rabbitmq消费者 A> 接收Mail订阅者模式消息：{}", message);
    }


    @RabbitListener(queues = "rabbit.fanout.queue.email2")
    public void fanoutEmailB(String message){
        logger.info("rabbitmq消费者 B> 接收Mail订阅者模式消息：{}", message);
    }

    @RabbitListener(queues = "rabbit.fanout.queue.sms")
    public void fanoutSms(String message){
        logger.info("rabbitmq消费者> 接收Sms订阅者模式消息：{}", message);
    }
}
