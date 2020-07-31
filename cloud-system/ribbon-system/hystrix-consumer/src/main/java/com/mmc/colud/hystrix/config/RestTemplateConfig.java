package com.mmc.colud.hystrix.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @packageName：com.mmc.colud.hystrix.config
 * @desrciption: restTemplate 配置
 * @author: GW
 * @date： 2020-07-30 15:33
 * @history: (version) author date desc
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
