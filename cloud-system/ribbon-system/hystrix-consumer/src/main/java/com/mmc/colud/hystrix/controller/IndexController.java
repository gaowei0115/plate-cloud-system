package com.mmc.colud.hystrix.controller;

import com.mmc.colud.hystrix.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @packageName：com.mmc.colud.hystrix.controller
 * @desrciption:
 * @author: GW
 * @date： 2020-07-30 15:32
 * @history: (version) author date desc
 */
@RestController
public class IndexController {


    @Autowired
    private IIndexService indexService;

    private Random random = new Random();

    @GetMapping("/index")
    public String index() {
        return indexService.business(random.nextInt(1000));
    }
}
