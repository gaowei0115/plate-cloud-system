package com.mmc.colud.hystrix.service.impl;

import com.mmc.colud.hystrix.constants.UrlMap;
import com.mmc.colud.hystrix.service.IIndexService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @packageName：com.mmc.colud.hystrix.service.impl
 * @desrciption:
 * @author: GW
 * @date： 2020-07-30 15:38
 * @history: (version) author date desc
 */
@Service("indexService")
public class IndexServiceImpl implements IIndexService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "indexFallBack")
    @Override
    public String business(int random) {
        return restTemplate.getForObject(UrlMap.INDEX_URL.getUrl() + random, String.class);
    }


    public String indexFallBack(int random) {
        return "501:error " + random;
    }
}
