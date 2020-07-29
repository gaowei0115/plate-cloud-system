package com.mmc.cloud.rbbion.worker.impl;

import com.mmc.cloud.rbbion.constants.UrlMap;
import com.mmc.cloud.rbbion.worker.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * @packageName：com.mmc.cloud.rbbion.worker.impl
 * @desrciption:
 * @author: GW
 * @date： 2020-07-29 11:14
 * @history: (version) author date desc
 */
@Component
public class IndexWorker implements Worker<Integer, String> {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String work(Integer integer) {
        return restTemplate.getForEntity(UrlMap.INDEX_URL.getUrl() + integer.intValue(), String.class).getBody();
    }
}
