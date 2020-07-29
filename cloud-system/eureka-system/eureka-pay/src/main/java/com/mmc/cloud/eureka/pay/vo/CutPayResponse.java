package com.mmc.cloud.eureka.pay.vo;

import java.io.Serializable;

/**
 * @packageName：com.mmc.cloud.eureka.pay.vo
 * @desrciption: 扣款响应参数
 * @author: GW
 * @date： 2020-07-28 14:01
 * @history: (version) author date desc
 */
public class CutPayResponse implements Serializable {

    private static final long serialVersionUID = 4799217904923047461L;


    private int status;

    private String resultCode;

    private String message;

    private String payNo;

    private String tradeNo;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}
