package com.mmc.cloud.eureka.pay.dao;

import com.mmc.cloud.eureka.pay.vo.CutPayVo;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @packageName：com.mmc.cloud.eureka.pay.dao
 * @desrciption: 支付dao
 * @author: GW
 * @date： 2020-07-28 14:05
 * @history: (version) author date desc
 */
@Repository
public class PayDao {

    private static final ConcurrentMap<String, CutPayVo> cacheDb = new ConcurrentHashMap<>(100);


    /**
     * 保存扣款流水信息
     * @param cutPayVo
     *          扣款实体
     */
    public void saveCutPay(CutPayVo cutPayVo) {
        cacheDb.put(cutPayVo.getPayNo(), cutPayVo);
    }

    /**
     * 查询扣款流水信息
     * @param payNo
     *          扣款流水号
     * @return
     *          实体对象
     */
    public CutPayVo queryCutPay(String payNo) {
        if (cacheDb.size() == 0) {
            return null;
        }
        return cacheDb.get(payNo);
    }

}
