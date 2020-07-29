package com.mmc.cloud.rbbion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @packageName：com.mmc.cloud.rbbion
 * @desrciption:
 * @author: GW
 * @date： 2020-07-29 10:31
 * @history: (version) author date desc
 */
@SpringBootApplication
@EnableEurekaClient
public class RibbonConsumerServer {

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerServer.class, args);
    }
}
