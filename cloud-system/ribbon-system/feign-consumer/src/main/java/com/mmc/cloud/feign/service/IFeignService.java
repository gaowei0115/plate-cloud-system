package com.mmc.cloud.feign.service;

import com.mmc.cloud.feign.vo.CutPayRequest;
import com.mmc.cloud.feign.vo.CutPayResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @desrciption:
 * @author: GW
 * @date： 2020-08-03 13:55
 * @history: (version) author date desc
 */
@FeignClient(value = "pay-node", path = "/pay")
public interface IFeignService {

    /**
     * 交易
     * @param message
     *          交易对象
     * @return
     *          交易结果
     */
    @RequestMapping("/index/{num}")
    String trade(@PathVariable("num") String message);


    /**
     * 模拟交易扣款
     * @param request
     *          扣款请求实体
     * @return
     *          扣款响应结果
     */
    @RequestMapping(value = "/pay/cut", method = RequestMethod.POST)
    CutPayResponse cutPay(@RequestBody CutPayRequest request);

}
