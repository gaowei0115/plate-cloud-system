package com.mmc.cloud.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @packageName：com.mmc.cloud.boot.config
 * @desrciption: 系统自定义参数配置
 * @author: GW
 * @date： 2020-07-27 14:32
 * @history: (version) author date desc
 */
@Component
public class AutoDefineConfig implements Serializable {

    private static final long serialVersionUID = 7166360713624654868L;

    @Value("${boot.auto.name}")
    private String name;
    @Value("${boot.auto.project}")
    private String project;

    /**
     * 随机字符串
     */
    @Value("${boot.auto.random.value}")
    private String randomValue;
    /**
     * 随机int类型
     */
    @Value("${boot.auto.random.int}")
    private int randomInt;
    /**
     * 随机long类型
     */
    @Value("${boot.auto.random.long}")
    private long randomLong;
    /**
     * 某个范围内随机int类型[1, 10]
     */
    @Value("${boot.auto.random.range.int}")
    private int randomRangeInt;
    /**
     * 某个范围内随机long类型 [1, 100]
     */
    @Value("${boot.auto.random.range.long}")
    private long randomRangeLong;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(String randomValue) {
        this.randomValue = randomValue;
    }

    public int getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(int randomInt) {
        this.randomInt = randomInt;
    }

    public long getRandomLong() {
        return randomLong;
    }

    public void setRandomLong(long randomLong) {
        this.randomLong = randomLong;
    }

    public int getRandomRangeInt() {
        return randomRangeInt;
    }

    public void setRandomRangeInt(int randomRangeInt) {
        this.randomRangeInt = randomRangeInt;
    }

    public long getRandomRangeLong() {
        return randomRangeLong;
    }

    public void setRandomRangeLong(long randomRangeLong) {
        this.randomRangeLong = randomRangeLong;
    }
}
