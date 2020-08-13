package com.mmc.cloud.boot.event;

import java.io.Serializable;

/**
 * @packageName：com.mmc.cloud.boot.event
 * @desrciption: 支付对象
 * @author: GW
 * @date： 2020-08-13 17:33
 * @history: (version) author date desc
 */
public class PayInfo implements Serializable {

    private static final long serialVersionUID = -1957287285138576831L;

    private String payNo;
    private long amount;

    private String tradeNo;
    private String payType;

    private int status;

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PayInfo{" +
                "payNo='" + payNo + '\'' +
                ", amount=" + amount +
                ", tradeNo='" + tradeNo + '\'' +
                ", payType='" + payType + '\'' +
                ", status=" + status +
                '}';
    }
}
