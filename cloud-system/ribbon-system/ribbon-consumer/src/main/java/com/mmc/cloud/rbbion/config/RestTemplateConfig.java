package com.mmc.cloud.rbbion.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @packageName：com.mmc.cloud.rbbion.config
 * @desrciption: restTemplate 配置
 * @author: GW
 * @date： 2020-07-29 10:34
 * @history: (version) author date desc
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

}
