package com.mmc.cloud.bus.rabbit.producer.controller;

import com.mmc.cloud.bus.rabbit.producer.service.IMessageService;
import com.mmc.cloud.bus.rabbit.producer.vo.LogInfo;
import com.mmc.cloud.bus.rabbit.producer.vo.MailVo;
import com.mmc.cloud.bus.rabbit.producer.vo.SmsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.producer.controller
 * @desrciption:
 * @author: GW
 * @date： 2020-08-20 16:30
 * @history: (version) author date desc
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @GetMapping("/simple")
    public String simple(String message) {
        messageService.sendSimpleMessage(message);
        return "success";
    }

    @GetMapping("/work")
    public String work() {
        messageService.sendWorkMessage(new Random().nextInt(1000));
        return "success";
    }

    @GetMapping("/fanout/mail")
    public String fanoutMail() {
        messageService.sendFanoutMailMessage(MailVo.buildDefault());
        return "success";
    }

    @GetMapping("/fanout/sms")
    public String fanoutSms() {
        SmsVo smsVo = new SmsVo();
        smsVo.setContent("恭喜您Mr%s注册成功");
        messageService.sendFanoutSmsMessage(smsVo);
        return "success";
    }

    @GetMapping("/direct/log")
    public String directLog(@RequestParam("type") int type, @RequestParam("message") String message) {
        LogInfo logInfo = new LogInfo();
        logInfo.setCause(message);
        if (type == 0) {
            logInfo.setType(LogInfo.LogTypeEnum.INFO);
        } else if (type == 1) {
            logInfo.setType(LogInfo.LogTypeEnum.DEBUG);
        } else if (type == 2) {
            logInfo.setType(LogInfo.LogTypeEnum.WARN);
        } else if (type == 3) {
            logInfo.setType(LogInfo.LogTypeEnum.ERROR);
        } else {
            return "error log type";
        }
        messageService.sendDirectMessage(logInfo);
        return "success";
    }

    @GetMapping("/topic")
    public String topic(@RequestParam("type") String type) {
        messageService.sendTopicMessage(type);
        return "success";
    }
}
