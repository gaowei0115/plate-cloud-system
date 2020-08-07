package com.mmc.cloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @packageName：PACKAGE_NAME
 * @desrciption: feign
 * @author: GW
 * @date： 2020-08-03 13:51
 * @history: (version) author date desc
 */

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FeignConsumerServer {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerServer.class, args);
    }
}
