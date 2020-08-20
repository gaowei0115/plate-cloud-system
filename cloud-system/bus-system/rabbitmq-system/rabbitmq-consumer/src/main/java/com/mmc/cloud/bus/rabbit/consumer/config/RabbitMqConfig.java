package com.mmc.cloud.bus.rabbit.consumer.config;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${rabbitmq.simple.queue}")
    public String simpleQueue;


}
