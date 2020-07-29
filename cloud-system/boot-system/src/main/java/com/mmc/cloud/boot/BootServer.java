package com.mmc.cloud.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @packageName：com.mmc.cloud.boot
 * @desrciption: 服务启动入口
 * @author: GW
 * @date： 2020-07-27 14:07
 * @history: (version) author date desc
 */
@SpringBootApplication
public class BootServer {

    /**
     * 服务启动main入口
     * @param args
     *          启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(BootServer.class, args);
    }

}
