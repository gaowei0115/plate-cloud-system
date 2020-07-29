package com.mmc.cloud.eureka.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @packageName：com.mmc.cloud.eureka.center
 * @desrciption: eureka 服务注册中心
 * @author: GW
 * @date： 2020-07-28 13:33
 * @history: (version) author date desc
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaCenterServer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCenterServer.class, args);
    }
}
