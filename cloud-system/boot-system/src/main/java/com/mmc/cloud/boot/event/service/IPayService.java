package com.mmc.cloud.boot.event.service;

import com.mmc.cloud.boot.event.PayInfo;

/**
 * @desrciption:
 * @author: GW
 * @date： 2020-08-13 17:36
 * @history: (version) author date desc
 */
public interface IPayService {

    /**
     * 付款操作
     * @param payInfo
     *          付款实体
     */
    void pay(PayInfo payInfo);
}
