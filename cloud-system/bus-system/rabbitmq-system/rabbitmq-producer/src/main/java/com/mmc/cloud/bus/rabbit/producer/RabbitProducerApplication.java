package com.mmc.cloud.bus.rabbit.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.producer
 * @desrciption: rabbitmq 生产者
 * @author: GW
 * @date： 2020-08-20 15:48
 * @history: (version) author date desc
 */
@SpringBootApplication
public class RabbitProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class, args);
    }
}
