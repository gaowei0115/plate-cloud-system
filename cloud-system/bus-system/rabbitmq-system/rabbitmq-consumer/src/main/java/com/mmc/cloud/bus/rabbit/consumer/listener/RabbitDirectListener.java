package com.mmc.cloud.bus.rabbit.consumer.listener;

import com.mmc.cloud.bus.rabbit.consumer.common.RabbitMqConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.consumer.listener
 * @desrciption: 路由模式-监听
 * @author: GW
 * @date： 2020-08-21 15:13
 * @history: (version) author date desc
 */
@Component
public class RabbitDirectListener {


    private static Logger logger = LoggerFactory.getLogger(RabbitDirectListener.class);

    @RabbitListener(queues = RabbitMqConstants.LOG_ERROR_QUEUE)
    @RabbitHandler
    public void logErrorListener(String message) {
        logger.info("路由模式-消费者接收error日志消息 >> {}", message);
    }

    @RabbitListener(queues = RabbitMqConstants.LOG_OTHER_QUEUE)
    @RabbitHandler
    public void logOtherListener(String message) {
        logger.info("路由模式-消费者接收other(info,debug,warn)日志消息 >> {}", message);
    }
}
