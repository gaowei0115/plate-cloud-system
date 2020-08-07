package com.mmc.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @packageName：com.mmc.cloud.config
 * @desrciption:
 * @author: GW
 * @date： 2020-08-05 17:42
 * @history: (version) author date desc
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {

    /**
     * @EnableConfigServer
     * 开启配置中心服务端 注解
     */

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer.class, args);
    }
}
