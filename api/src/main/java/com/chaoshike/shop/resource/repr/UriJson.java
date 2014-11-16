package com.chaoshike.shop.resource.repr;

/**
 * Created by weizhigang on 14-11-16.
 */
public class UriJson {
    private String desc;
    private String url;

    public UriJson(String desc, String url) {
        this.desc = desc;
        this.url = url;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
