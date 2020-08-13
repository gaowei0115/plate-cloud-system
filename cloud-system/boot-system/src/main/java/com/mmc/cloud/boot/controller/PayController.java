package com.mmc.cloud.boot.controller;

import com.mmc.cloud.boot.event.PayInfo;
import com.mmc.cloud.boot.event.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @packageName：com.mmc.cloud.boot.controller
 * @desrciption:
 * @author: GW
 * @date： 2020/8/13 21:46
 * @history: (version) author date desc
 */
@RestController
public class PayController {

    @Autowired
    private IPayService payService;

    @GetMapping("/pay")
    public String pay(){
        PayInfo payInfo = new PayInfo();
        payInfo.setPayNo("pay20200813000001");
        payInfo.setAmount(100000);
        payInfo.setPayType("01");
        payInfo.setTradeNo("sale202008130000001");
        payInfo.setStatus(1);
        payService.pay(payInfo);
        return "Success";
    }
}
