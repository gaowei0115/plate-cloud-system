package com.mmc.cloud.bus.rabbit.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.consumer
 * @desrciption:
 * @author: GW
 * @date： 2020-08-20 16:33
 * @history: (version) author date desc
 */
@SpringBootApplication
public class RabbitConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumerApplication.class, args);
    }
}
