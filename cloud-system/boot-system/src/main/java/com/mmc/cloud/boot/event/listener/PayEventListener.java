package com.mmc.cloud.boot.event.listener;

import com.mmc.cloud.boot.event.PayEvent;
import org.springframework.context.ApplicationListener;

/**
 * @packageName：com.mmc.cloud.boot.event.listener
 * @desrciption:
 * @author: GW
 * @date： 2020-08-13 17:42
 * @history: (version) author date desc
 */
public class PayEventListener implements ApplicationListener<PayEvent> {


    @Override
    public void onApplicationEvent(PayEvent event) {
        System.out.println(this.getClass().getName() + " -- 支付事件监听 ");
        System.out.println("支付信息 " + event.getPayInfo().toString());
    }
}
