package com.mmc.cloud.bus.rabbit.producer.vo;

import java.io.Serializable;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.producer.vo
 * @desrciption:
 * @author: GW
 * @date： 2020-08-21 10:29
 * @history: (version) author date desc
 */
public class SmsVo implements Serializable {

    private static final long serialVersionUID = -1967963131669761876L;

    private String phone;

    private String content;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
