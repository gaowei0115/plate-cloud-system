package com.mmc.cloud.eureka.pay.controller;

import com.mmc.cloud.eureka.pay.service.IPayService;
import com.mmc.cloud.eureka.pay.vo.CutPayRequest;
import com.mmc.cloud.eureka.pay.vo.CutPayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @packageName：com.mmc.cloud.eureka.pay.controller
 * @desrciption:
 * @author: GW
 * @date： 2020-07-28 13:46
 * @history: (version) author date desc
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private IPayService payService;

    /**
     * 交易支付平台扣款
     * @param request
     *          请求参数
     * @return
     *          响应扣款结果
     */
    @PostMapping("/cut")
    public @ResponseBody CutPayResponse cutPay(@RequestBody CutPayRequest request) {
        return payService.cutPay(request);
    }

}
