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
 * @date： 2020-08-20 17:21
 * @history: (version) author date desc
 */
@Component
public class RabbitWorkListener {

    private final Logger logger = LoggerFactory.getLogger(RabbitSimpleListener.class);


    @RabbitListener(queuesToDeclare = @Queue("rabbit.work.queue"))
    public void listener(String message) {
        logger.info("rabbitmq消费者>1 接收工作模式消息：{}", message);
    }


    @RabbitListener(queuesToDeclare = @Queue("rabbit.work.queue"))
    public void listener1(String message) {
        logger.info("rabbitmq消费者>2 接收工作模式消息：{}", message);
    }

}
