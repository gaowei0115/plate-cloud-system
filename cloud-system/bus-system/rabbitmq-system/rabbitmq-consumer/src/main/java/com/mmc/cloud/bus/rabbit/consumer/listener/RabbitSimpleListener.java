package com.mmc.cloud.bus.rabbit.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.consumer.listener
 * @desrciption:
 * @author: GW
 * @date： 2020-08-20 16:36
 * @history: (version) author date desc
 */
@Component
public class RabbitSimpleListener {

    private final Logger logger = LoggerFactory.getLogger(RabbitSimpleListener.class);


    @RabbitListener(queuesToDeclare = @Queue("rabbit.simple.queue"))
    public void listener(String message) {
        logger.info("rabbitmq消费者接收简单模式消息：{}", message);
    }
}
