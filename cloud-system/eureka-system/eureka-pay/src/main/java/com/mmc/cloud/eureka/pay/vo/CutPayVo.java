package com.mmc.cloud.eureka.pay.vo;

import java.io.Serializable;

/**
 * @packageName：com.mmc.cloud.eureka.pay.vo
 * @desrciption: 支付扣款实体对象
 * @author: GW
 * @date： 2020-07-28 14:06
 * @history: (version) author date desc
 */
public class CutPayVo implements Serializable {

    private static final long serialVersionUID = 1355956787441567568L;

    private Long id;

    private String payNo;

    private String tradeNo;

    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
