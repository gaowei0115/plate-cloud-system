package com.mmc.cloud.bus.rabbit.producer.controller;

import com.mmc.cloud.bus.rabbit.producer.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
