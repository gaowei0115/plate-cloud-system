package com.mmc.cloud.boot.common;

/**
 * @desrciption: 随机数据type
 * @author: GW
 * @date： 2020-07-27 15:10
 * @history: (version) author date desc
 */
public enum RandomType {

    TYPE0(0, "所有随机数"),
    TYPE1(1, "字符串随机数"),
    TYPE2(2, "int类型随机数"),
    TYPE3(3, "long类型随机数"),
    TYPE4(4, "int类型范围内随机数"),
    TYPE5(5, "long类型范围内随机数");

    private int type;
    private String mark;

    RandomType(int type, String mark) {
        this.type = type;
        this.mark = mark;
    }

    public int getType() {
        return type;
    }

    public String getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "[type:" + getType() + ", mark:" + getMark() + "]";
    }
}
