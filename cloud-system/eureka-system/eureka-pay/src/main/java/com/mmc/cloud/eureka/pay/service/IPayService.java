package com.mmc.cloud.eureka.pay.service;

import com.mmc.cloud.eureka.pay.vo.CutPayRequest;
import com.mmc.cloud.eureka.pay.vo.CutPayResponse;

/**
 * @desrciption: 支付Service接口
 * @author: GW
 * @date： 2020-07-28 14:02
 * @history: (version) author date desc
 */
public interface IPayService {

    /**
     * 交易扣款操作
     * @param request
     *        扣款请求实体
     * @return
     *        扣款结果
     */
    CutPayResponse cutPay(CutPayRequest request);
}
