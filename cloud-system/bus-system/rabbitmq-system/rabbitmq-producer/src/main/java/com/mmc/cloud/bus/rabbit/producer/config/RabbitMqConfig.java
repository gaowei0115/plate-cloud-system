package com.mmc.cloud.bus.rabbit.producer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${rabbitmq.fanout.exchange.email}")
    public String fanoutMailExchange;

    @Value("${rabbitmq.fanout.exchange.sms}")
    public String fanoutSmsExchange;

    @Value("${rabbitmq.fanout.queue.email1}")
    public String fanoutMailQueueA;

    @Value("${rabbitmq.fanout.queue.email2}")
    public String fanoutMailQueueB;

    @Value("${rabbitmq.fanout.queue.sms}")
    public String fanoutSmsQueue;


    /**
     * 订阅者模式-邮件交换机
     * @return
     *      FanoutExchange对象
     */
    @Bean
    public FanoutExchange mailExchange() {
        return new FanoutExchange(fanoutMailExchange);
    }

    /**
     * 订阅者模式-短信交换机
     * @return
     *      FanoutExchange对象
     */
    @Bean
    public FanoutExchange smsExchange() {
        return new FanoutExchange(fanoutSmsExchange);
    }

    /**
     * 声明一个fanout模式 - 邮件队列
     * @return
     *      邮件队列对象
     */
    @Bean
    public Queue mailQueueA() {
        return new Queue(fanoutMailQueueA);
    }

    /**
     * 声明一个fanout模式 - 邮件队列
     * @return
     *      邮件队列对象
     */
    @Bean
    public Queue mailQueueB() {
        return new Queue(fanoutMailQueueB);
    }

    /**
     * 声明一个fanout模式 - 短信队列
     * @return
     *      短信队列对象
     */
    @Bean
    public Queue smsQueue() {
        return new Queue(fanoutSmsQueue);
    }


    /**
     * 绑定邮件 exchange与queue
     * @param mailExchange
     *          交换机
     * @param mailQueueA
     *          队列
     * @return
     *          绑定对象
     */
    @Bean
    public Binding bindingMailExchangeA(FanoutExchange mailExchange, Queue mailQueueA){
        return BindingBuilder.bind(mailQueueA).to(mailExchange);
    }

    /**
     * 绑定邮件 exchange与queue
     * @param mailExchange
     *          交换机
     * @param mailQueueB
     *          队列
     * @return
     *          绑定对象
     */
    @Bean
    public Binding bindingMailExchangeB(FanoutExchange mailExchange, Queue mailQueueB){
        return BindingBuilder.bind(mailQueueB).to(mailExchange);
    }

    /**
     * 绑定短信 exchange与queue
     * @param smsExchange
     *          交换机
     * @param smsQueue
     *          队列
     * @return
     *          绑定对象
     */
    @Bean
    public Binding bindingSmsExchange(FanoutExchange smsExchange, Queue smsQueue) {
        return BindingBuilder.bind(smsQueue).to(smsExchange);
    }


    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //Mandatory强制的
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        // 消息确认
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            logger.info("RabbitMQ Message Confirm:      >>state: {}", ack ? "成功" : "失败");
            logger.info("RabbitMQ Message Confirm:      >>correlation data: {}", correlationData);
            if (ack) {
                logger.info("RabbitMQ Message Confirm:      >>cause: {}", cause);
            }
        });

        // 消息返回
        // message 返回消息、replyCode 回应码、replyText 回应信息、exchange 交换机、routingKey 路由key
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            logger.info("RabbitMQ Message return:      >>message: {}", message);
            logger.info("RabbitMQ Message return:      >>replyCode: {}", replyCode);
            logger.info("RabbitMQ Message return:      >>replyText: {}", replyText);
        });
        return rabbitTemplate;
    }

}
