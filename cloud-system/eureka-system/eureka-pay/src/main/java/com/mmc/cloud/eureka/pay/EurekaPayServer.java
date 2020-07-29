package com.mmc.cloud.eureka.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @packageName：com.mmc.cloud.eureka.pay
 * @desrciption: 模拟支付平台启动入口
 * @author: GW
 * @date： 2020-07-28 13:45
 * @history: (version) author date desc
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaPayServer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaPayServer.class, args);
    }
}
