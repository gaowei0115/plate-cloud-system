package com.mmc.cloud.boot.event.service.impl;

import com.mmc.cloud.boot.event.PayEvent;
import com.mmc.cloud.boot.event.PayInfo;
import com.mmc.cloud.boot.event.service.IPayService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @packageName：com.mmc.cloud.boot.event.service.impl
 * @desrciption:
 * @author: GW
 * @date： 2020-08-13 17:37
 * @history: (version) author date desc
 */
@Service
public class PayServiceImpl implements IPayService, ApplicationContextAware {


    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void pay(PayInfo payInfo) {
        System.out.println("保存支付信息");
        PayEvent payEvent = new PayEvent(this, payInfo);
        System.out.println("发布支付成功事件消息");
        applicationEventPublisher.publishEvent(payEvent);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationEventPublisher = applicationContext;
    }
}
