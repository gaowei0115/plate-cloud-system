package com.mmc.cloud.rbbion.controller;

import com.mmc.cloud.rbbion.worker.impl.IndexWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @packageName：com.mmc.cloud.rbbion.controller
 * @desrciption:
 * @author: GW
 * @date： 2020-07-29 11:24
 * @history: (version) author date desc
 */
@RestController
@RequestMapping("/mock")
public class MockIndexController {

    @Autowired
    private IndexWorker indexWorker;

    @GetMapping("/index")
    public String index() {
        return indexWorker.work(new Random().nextInt(1000));
    }

}
