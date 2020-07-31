package com.mmc.cloud.eureka.pay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @packageName：com.mmc.cloud.eureka.pay.controller
 * @desrciption: 主控制
 * @author: GW
 * @date： 2020-07-28 14:25
 * @history: (version) author date desc
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private EurekaDiscoveryClient client;


    @GetMapping("/{num}")
    public String index(@PathVariable("num") int num) throws InterruptedException {
        logger.debug("访问 index/{num}..");
        List<ServiceInstance> instances = client.getInstances("pay-node");
        ServiceInstance instance = instances.get(0);
        logger.debug(instances.toString());

        Random random = new Random();
        int sleep = random.nextInt(3000);
        logger.debug("thread sleep {} ms", sleep);
        Thread.sleep(sleep);

        return num + ".html";
    }
}
