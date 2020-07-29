package com.mmc.cloud.eureka.pay.service.impl;

import com.mmc.cloud.eureka.pay.dao.PayDao;
import com.mmc.cloud.eureka.pay.service.IPayService;
import com.mmc.cloud.eureka.pay.vo.CutPayRequest;
import com.mmc.cloud.eureka.pay.vo.CutPayResponse;
import com.mmc.cloud.eureka.pay.vo.CutPayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @packageName：com.mmc.cloud.eureka.pay.service.impl
 * @desrciption: 支付Service实现
 * @author: GW
 * @date： 2020-07-28 14:04
 * @history: (version) author date desc
 */
@Service("payService")
public class PayServiceImpl implements IPayService {

    @Autowired
    private PayDao payDao;

    private volatile AtomicLong idIcr = new AtomicLong(1000);


    @Override
    public CutPayResponse cutPay(CutPayRequest request) {
        CutPayResponse response = new CutPayResponse();
        response.setStatus(-1);
        response.setResultCode("F_P_999");
        response.setMessage("系统异常");
        if (request == null) {
            return response;
        }
        if (request.getTradeNo() == null) {
            response.setResultCode("F_P_001");
            response.setMessage("交易流水号为空");
            return response;
        }
        CutPayVo payVo = new CutPayVo();
        payVo.setId(idIcr.getAndIncrement());
        payVo.setAmount(request.getMoney());
        payVo.setPayNo(payNo());
        payVo.setTradeNo(request.getTradeNo());
        payDao.saveCutPay(payVo);
        response.setStatus(0);
        response.setResultCode("S_P_001");
        response.setMessage("成功");
        return response;
    }

    private volatile AtomicLong noSeq = new AtomicLong(10000);
    private Random random = new Random();

    private String payNo() {
        String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        char[] preArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        return preArray[random.nextInt(10)] + dateStr + noSeq.getAndIncrement();
    }
}
