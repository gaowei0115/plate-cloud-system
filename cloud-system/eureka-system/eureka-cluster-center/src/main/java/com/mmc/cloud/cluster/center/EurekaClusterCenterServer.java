package com.mmc.cloud.cluster.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @packageName：com.mmc.cloud.cluster.center
 * @desrciption:
 * @author: GW
 * @date： 2020-07-29 9:45
 * @history: (version) author date desc
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaClusterCenterServer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClusterCenterServer.class, args);
    }
}
