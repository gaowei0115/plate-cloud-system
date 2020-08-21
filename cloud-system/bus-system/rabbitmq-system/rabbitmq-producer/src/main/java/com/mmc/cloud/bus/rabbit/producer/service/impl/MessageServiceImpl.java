package com.mmc.cloud.bus.rabbit.producer.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mmc.cloud.bus.rabbit.producer.config.RabbitMqConfig;
import com.mmc.cloud.bus.rabbit.producer.config.RabbitMqDirectConfig;
import com.mmc.cloud.bus.rabbit.producer.service.IMessageService;
import com.mmc.cloud.bus.rabbit.producer.vo.LogInfo;
import com.mmc.cloud.bus.rabbit.producer.vo.MailVo;
import com.mmc.cloud.bus.rabbit.producer.vo.SmsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
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

    @Override
    public void sendFanoutMailMessage(MailVo mailVo) {
        int count = new Random().nextInt(1000);
        String message = "";
        while (count > 0) {
            if (sequence.get() > 99999999) {
                sequence.set(10000000);
            }
            String toMail = sequence.getAndIncrement() + "qq.com";
            mailVo.setToEmail(toMail);
            message = JSON.toJSONString(mailVo);
            logger.info("发送邮件信息：{}", message);

            rabbitTemplate.convertAndSend(rabbitMqConfig.fanoutMailExchange, "", message);
            count--;
        }
    }

    private static long max = 2222222222222L;

    @Override
    public void sendFanoutSmsMessage(SmsVo smsVo) {
        sequence.set(1000000000000L);
        int count = new Random().nextInt(1000);
        String message = "";

        char[] names = new char[]{'A', 'B', 'C', 'D', 'E', 'F'
                , 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'L', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Random random = new Random();
        while (count > 0) {
            if (sequence.get() > max) {
                sequence.set(1000000000000L);
            }
            String phone = sequence.getAndIncrement() + "";
            smsVo.setPhone(phone);
            String name = String.format("%s-%s-%s", names[random.nextInt(26)], random.nextInt(26), names[random.nextInt(26)]);
            smsVo.setContent(String.format(smsVo.getContent(), name));
            message = JSON.toJSONString(smsVo);
            logger.info("发送短信信息：{}", message);

            rabbitTemplate.convertAndSend(rabbitMqConfig.fanoutSmsExchange, "", message);
            count--;
        }
    }

    @Override
    public void sendDirectMessage(LogInfo logInfo) {
        String message = JSON.toJSONString(logInfo);
        logger.info("路由模式-发送日志信息 {}", message);
        logger.info("路由模式-发送日志消息类型 {}", logInfo.getType());
        if (logInfo.getType() == LogInfo.LogTypeEnum.ERROR) {
            logger.info("路由模式-发送日志消息进入error队列");
            rabbitTemplate.convertAndSend(RabbitMqDirectConfig.logExchangeName, RabbitMqDirectConfig.logErrorKeyName, message);
        } else {
            logger.info("路由模式-发送日志消息进入other(info,warn,debug)队列");
            rabbitTemplate.convertAndSend(RabbitMqDirectConfig.logExchangeName, RabbitMqDirectConfig.logOtherKeyName, message);
        }
    }
}
