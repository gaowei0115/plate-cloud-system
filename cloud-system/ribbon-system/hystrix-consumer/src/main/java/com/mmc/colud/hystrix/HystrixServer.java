package com.mmc.colud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @packageName：com.mmc.colud.hystrix
 * @desrciption: hystrix 容错保护机制
 * @author: GW
 * @date： 2020-07-30 15:28
 * @history: (version) author date desc
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class HystrixServer {


    /**
     * EnableCircuitBreaker 开启熔断器
     *
     * EnableHystrixDashboard 开启 hystrix仪表盘监视器
     */

    public static void main(String[] args) {
        SpringApplication.run(HystrixServer.class, args);
    }
}
