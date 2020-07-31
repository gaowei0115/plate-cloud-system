package com.mmc.colud.hystrix.constants;

/**
 * @desrciption:
 * @author: GW
 * @date： 2020-07-29 11:19
 * @history: (version) author date desc
 */
public enum UrlMap {
    INDEX_URL("http://PAY-NODE/pay/index/", "index url");

    private String url;
    private String mark;

    UrlMap(String url, String mark) {
        this.url = url;
        this.mark = mark;
    }

    public String getUrl() {
        return url;
    }

    public String getMark() {
        return mark;
    }}
