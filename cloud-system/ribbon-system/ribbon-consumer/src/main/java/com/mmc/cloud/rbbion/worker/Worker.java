package com.mmc.cloud.rbbion.worker;

/**
 * @desrciption:
 * @author: GW
 * @date： 2020-07-29 11:14
 * @history: (version) author date desc
 */
public interface Worker<IN, OUT> {

    /**
     * 业务执行入口
     * @param in
     *          入参
     * @return
     *          出参
     */
    OUT work(IN in);
}
