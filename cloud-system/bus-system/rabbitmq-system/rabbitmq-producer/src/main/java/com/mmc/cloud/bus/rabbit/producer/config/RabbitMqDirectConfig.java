package com.mmc.cloud.bus.rabbit.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.producer.config
 * @desrciption:
 * @author: GW
 * @date： 2020-08-21 14:41
 * @history: (version) author date desc
 */
@Configuration
@PropertySource(value = {"classpath:property/config-rabbitmq-direct.properties"})
public class RabbitMqDirectConfig {

    public static String logExchangeName;

    public static String logErrorQueueName;

    public static String logOtherQueueName;

    public static String logErrorKeyName;

    public static String logOtherKeyName;


    @Bean
    public DirectExchange logExchange() {
        return new DirectExchange(logExchangeName);
    }

    @Bean
    public Queue logErrorQueue() {
        return new Queue(logErrorQueueName);
    }

    @Bean
    public Queue logOtherQueue() {
        return new Queue(logOtherQueueName);
    }

    /**
     * 路由模式 - 绑定交换机与error队列
     * @param logExchange
     *          log交换机
     * @param logErrorQueue
     *          log error 队列
     * @return
     *          Binding对象
     */
    @Bean
    public Binding bindingLogError(DirectExchange logExchange, Queue logErrorQueue) {
        return BindingBuilder.bind(logErrorQueue).to(logExchange).with(logErrorKeyName);
    }

    /**
     * 路由模式 - 绑定交换机与other队列
     * @param logExchange
     *          log交换机
     * @param logOtherQueue
     *          log info、debug、warn队列
     * @return
     *          Binding对象
     */
    @Bean
    public Binding bindingLogOther(DirectExchange logExchange, Queue logOtherQueue) {
        return BindingBuilder.bind(logOtherQueue).to(logExchange).with(logOtherKeyName);
    }

    @Value("${rabbit.direct.exchange.log}")
    public void setLogExchangeName(String logExchange) {
        RabbitMqDirectConfig.logExchangeName = logExchange;
    }

    @Value("${rabbit.direct.queue.log.error}")
    public void setLogErrorQueueName(String logErrorQueue) {
        RabbitMqDirectConfig.logErrorQueueName = logErrorQueue;
    }

    @Value("${rabbit.direct.queue.log.other}")
    public void setLogOtherQueueName(String logOtherQueue) {
        RabbitMqDirectConfig.logOtherQueueName = logOtherQueue;
    }

    @Value("${rabbit.direct.routing.log.error.key}")
    public void setLogErrorKeyName(String logErrorKey) {
        RabbitMqDirectConfig.logErrorKeyName = logErrorKey;
    }

    @Value("${rabbit.direct.routing.log.other.key}")
    public void setLogOtherKeyName(String logOtherKey) {
        RabbitMqDirectConfig.logOtherKeyName = logOtherKey;
    }
}
