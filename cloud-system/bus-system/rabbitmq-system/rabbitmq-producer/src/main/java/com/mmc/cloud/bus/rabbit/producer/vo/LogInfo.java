package com.mmc.cloud.bus.rabbit.producer.vo;

import java.io.Serializable;

/**
 * @packageName：com.mmc.cloud.bus.rabbit.producer.vo
 * @desrciption:
 * @author: GW
 * @date： 2020-08-21 14:55
 * @history: (version) author date desc
 */
public class LogInfo implements Serializable {

    private static final long serialVersionUID = -575062934683381243L;

    private LogTypeEnum type;

    private String cause;

    public LogTypeEnum getType() {
        return type;
    }

    public void setType(LogTypeEnum type) {
        this.type = type;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public enum LogTypeEnum{
        INFO,
        DEBUG,
        WARN,
        ERROR
    }
}
