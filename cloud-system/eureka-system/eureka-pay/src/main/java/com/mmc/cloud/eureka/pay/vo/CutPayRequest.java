package com.mmc.cloud.eureka.pay.vo;

import java.io.Serializable;

/**
 * @packageName：com.mmc.cloud.eureka.pay.vo
 * @desrciption: 扣款请求参数
 * @author: GW
 * @date： 2020-07-28 13:59
 * @history: (version) author date desc
 */
public class CutPayRequest implements Serializable {

    private static final long serialVersionUID = -4061311221202968221L;

    private String cutPayNo;

    private long money;

    private String tradeNo;

    private String accountNo;

    private String password;

    public String getCutPayNo() {
        return cutPayNo;
    }

    public void setCutPayNo(String cutPayNo) {
        this.cutPayNo = cutPayNo;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
