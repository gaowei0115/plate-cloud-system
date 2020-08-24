package com.mmc.cloud.bus.rabbit.producer.service;

import com.mmc.cloud.bus.rabbit.producer.vo.LogInfo;
import com.mmc.cloud.bus.rabbit.producer.vo.MailVo;
import com.mmc.cloud.bus.rabbit.producer.vo.SmsVo;

/**
 * @desrciption:
 * @author: GW
 * @date： 2020-08-20 16:17
 * @history: (version) author date desc
 */
public interface IMessageService {

    /**
     * 简单消息发送
     * @param message
     *      消息实体
     */
    void sendSimpleMessage(String message);

    /**
     * 工作模式
     * @param num
     *      发送消息条目
     */
    void sendWorkMessage(int num);

    /**
     * 订阅者模式-邮件
     * @param mailVo
     *          邮件对象
     */
    void sendFanoutMailMessage(MailVo mailVo);

    /**
     * 订阅者模式 - 短信
     * @param smsVo
     *          短信对象
     */
    void sendFanoutSmsMessage(SmsVo smsVo);

    /**
     * 路由模式 - 发送消息（info、debug、warn、error）
     * @param logInfo
     *          消息实体
     */
    void sendDirectMessage(LogInfo logInfo);

    /**
     * 主题模式 - 发送消息
     */
    void sendTopicMessage(String type);
}
