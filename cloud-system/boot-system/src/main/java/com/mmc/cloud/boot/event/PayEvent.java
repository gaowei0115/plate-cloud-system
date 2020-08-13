package com.mmc.cloud.boot.event;

import org.springframework.context.ApplicationEvent;

/**
 * @packageName：com.mmc.cloud.boot.event
 * @desrciption: 支付付款事件
 * @author: GW
 * @date： 2020-08-13 17:34
 * @history: (version) author date desc
 */
public class PayEvent extends ApplicationEvent {

    private final PayInfo payInfo;

    public PayEvent(Object source, PayInfo payInfo) {
        super(source);
        this.payInfo = payInfo;
    }

    public PayInfo getPayInfo() {
        return payInfo;
    }
}
