package com.mmc.colud.hystrix.service;

/**
 * @desrciption:
 * @author: GW
 * @date： 2020-07-30 15:37
 * @history: (version) author date desc
 */
public interface IIndexService {

    /**
     * 业务操作
     * @param random
     *          随机数
     * @return
     *          参数
     */
    String business(int random);
}
