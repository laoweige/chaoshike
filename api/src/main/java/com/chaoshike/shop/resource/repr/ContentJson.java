package com.chaoshike.shop.resource.repr;

public class ContentJson {

    private int regionId;
    private int type;
    private String keyword;
    private String url;
    private String imagePath;

    public ContentJson(int regionId, int type, String keyword, String url, String imagePath) {
        this.regionId = regionId;
        this.type = type;
        this.keyword = keyword;
        this.url = url;
        this.imagePath = imagePath;
    }

    public int getRegionId() {
        return regionId;

    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
