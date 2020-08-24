package com.mmc.cloud.bus.rabbit.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.consumer.listener
 * @desrciption:
 * @author: GW
 * @date： 2020-08-24 17:08
 * @history: (version) author date desc
 */
@Component
public class RabbitmqTopicListener {

    private static Logger logger = LoggerFactory.getLogger(RabbitmqTopicListener.class);

    @RabbitListener(queues = "rabbit.topic.queue.01")
    public void topicPay(String message) {
        logger.info("主题模式-消费者接收pay消息{}", message);
    }

    @RabbitListener(queues = "rabbit.direct.queue.02")
    public void topicTrade(String message) {
        logger.info("主题模式-消费者接收trade消息{}", message);
    }
}
