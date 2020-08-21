package com.mmc.cloud.bus.rabbit.producer.vo;

import java.io.Serializable;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.producer.vo
 * @desrciption:
 * @author: GW
 * @date： 2020-08-21 10:28
 * @history: (version) author date desc
 */
public class MailVo implements Serializable {

    private static final long serialVersionUID = -6711792314518354183L;

    private String fromEmail;

    private String title;

    private String toEmail;

    private String content;

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static MailVo buildDefault() {
        MailVo mailVo = new MailVo();
        mailVo.setFromEmail("gw@mmc.com");
        mailVo.setTitle("通知");
        mailVo.setContent("最新支付公告");
        return mailVo;
    }
}
