package com.mmc.cloud.way.zuul;

import com.mmc.cloud.way.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @packageName：com.mmc.cloud.way.zuul
 * @desrciption:
 * @author: GW
 * @date： 2020-08-03 15:55
 * @history: (version) author date desc
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulWayServer {

    public static void main(String[] args) {
        SpringApplication.run(ZuulWayServer.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
