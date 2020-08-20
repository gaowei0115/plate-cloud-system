package com.mmc.cloud.bus.rabbit.producer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.producer.config
 * @desrciption:
 * @author: GW
 * @date： 2020-08-20 15:59
 * @history: (version) author date desc
 */
@Configuration
@PropertySource(value = {"classpath:property/config-rabbitmq.properties"})
public class RabbitMqConfig {

    private final Logger logger = LoggerFactory.getLogger(RabbitMqConfig.class);

    @Value("${rabbitmq.simple.queue}")
    public String simpleQueue;

    @Value("${rabbitmq.work.queue}")
    public String workQueue;



    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //Mandatory强制的
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                logger.info("ConfirmCallback:     " + "相关数据：" + correlationData);
                logger.info("ConfirmCallback:     " + "确认情况：" + b);
                logger.info("ConfirmCallback:     " + "原因：" + s);
            }
        });

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                logger.info("ReturnCallback:     " + "消息：" + message);
                logger.info("ReturnCallback:     " + "回应码：" + replyCode);
                logger.info("ReturnCallback:     " + "回应信息：" + replyText);
                logger.info("ReturnCallback:     " + "交换机：" + exchange);
                logger.info("ReturnCallback:     " + "路由键：" + routingKey);
            }
        });
        return rabbitTemplate;
    }

}
