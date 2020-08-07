package com.mmc.cloud.feign.controller;

import com.mmc.cloud.feign.service.IFeignService;
import com.mmc.cloud.feign.vo.CutPayRequest;
import com.mmc.cloud.feign.vo.CutPayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @packageName：com.mmc.cloud.feign.controller
 * @desrciption:
 * @author: GW
 * @date： 2020-08-03 14:02
 * @history: (version) author date desc
 */
@RestController
public class FeignController {

    @Autowired
    private IFeignService feignService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String tradeFeign() {
        return feignService.trade(new Random().nextInt(1000) + "");
    }


    @RequestMapping(value = "/cutPay", method = RequestMethod.POST)
    public @ResponseBody
    CutPayResponse cutPay(@RequestBody CutPayRequest request) {
        return feignService.cutPay(request);
    }
}
