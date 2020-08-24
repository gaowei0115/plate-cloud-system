package com.mmc.cloud.bus.rabbit.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.producer.config
 * @desrciption:
 * @author: GW
 * @date： 2020-08-24 16:38
 * @history: (version) author date desc
 */
@Configuration
@PropertySource("classpath:property/config-rabbitmq-topic.properties")
public class RabbitMqTopicConfig {

    /**
     * 主题模式 - 交换机
     */
    public static String topicExchange;

    /**
     * 主题模式 - a队列
     */
    public static String topicQueueA;

    /**
     * 主题模式 - b队列
     */
    public static String topicQueueB;

    /**
     * 主题模式 - 包含pay绑定路由key
     */
    public static String topicRoutingPayKey;

    /**
     * 主题模式 - trade结尾绑定路由key
     */
    public static String topicRoutingTradeKey;


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    public Queue topicQueueA() {
        return new Queue(topicQueueA);
    }

    @Bean
    public Queue topicQueueB() {
        return new Queue(topicQueueB);
    }

    @Bean
    public Binding topicBindQueueA(Queue topicQueueA, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueA).to(topicExchange).with(topicRoutingPayKey);
    }

    @Bean
    public Binding topicBindQueueB(Queue topicQueueB, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueB).to(topicExchange).with(topicRoutingTradeKey);
    }

    @Value("${rabbit.topic.exchange}")
    public void setTopicExchange(String topicExchange) {
        RabbitMqTopicConfig.topicExchange = topicExchange;
    }

    @Value("${rabbit.topic.queue.a}")
    public void setTopicQueueA(String topicQueueA) {
        RabbitMqTopicConfig.topicQueueA = topicQueueA;
    }

    @Value("${rabbit.topic.queue.b}")
    public void setTopicQueueB(String topicQueueB) {
        RabbitMqTopicConfig.topicQueueB = topicQueueB;
    }

    @Value("${rabbit.topic.routing.pay.key}")
    public void setTopicRoutingPayKey(String topicRoutingPayKey) {
        RabbitMqTopicConfig.topicRoutingPayKey = topicRoutingPayKey;
    }

    @Value("${rabbit.topic.routing.trade.key}")
    public void setTopicRoutingTradeKey(String topicRoutingTradeKey) {
        RabbitMqTopicConfig.topicRoutingTradeKey = topicRoutingTradeKey;
    }
}

