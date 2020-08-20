package com.mmc.cloud.bus.rabbit.producer.service;

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
}
