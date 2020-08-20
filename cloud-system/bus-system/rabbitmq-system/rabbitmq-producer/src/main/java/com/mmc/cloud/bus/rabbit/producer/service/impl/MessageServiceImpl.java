package com.mmc.cloud.bus.rabbit.producer.service.impl;

import com.mmc.cloud.bus.rabbit.producer.config.RabbitMqConfig;
import com.mmc.cloud.bus.rabbit.producer.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.producer.service.impl
 * @desrciption:
 * @author: GW
 * @date： 2020-08-20 16:18
 * @history: (version) author date desc
 */
@Service
public class MessageServiceImpl implements IMessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMqConfig rabbitMqConfig;

    private static AtomicLong sequence = new AtomicLong(10000000);

    @Override
    public void sendSimpleMessage(String message) {
        logger.info("发送rabbitmq简单模式消息 {}", message);
        rabbitTemplate.convertAndSend(rabbitMqConfig.simpleQueue, message);
    }

    @Override
    public void sendWorkMessage(int num) {
        String pattern = "支付订单号：orderNo=%s%s";
        String message = "";
        logger.info("发送订单数目：{}", num);
        while (num > 0) {
            if (sequence.get() > 99999999) {
                sequence.set(10000000);
            }
            message = String.format(pattern, System.currentTimeMillis(), sequence.getAndIncrement());
            logger.info("发送rabbitmq工作模式消息 {}", message);
            rabbitTemplate.convertAndSend(rabbitMqConfig.workQueue, message);
            num--;
        }
    }
}
