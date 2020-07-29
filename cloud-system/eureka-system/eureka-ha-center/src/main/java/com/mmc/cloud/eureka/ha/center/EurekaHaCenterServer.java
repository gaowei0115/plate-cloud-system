package com.mmc.cloud.eureka.ha.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @packageName：com.mmc.cloud.eureka.ha.center
 * @desrciption:
 * @author: GW
 * @date： 2020-07-28 15:28
 * @history: (version) author date desc
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaHaCenterServer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHaCenterServer.class, args);
    }
}
