package com.chaoshike.shop.resource.repr;


import java.util.List;

public class RegionJson {
    int id;

    public RegionJson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private String bgColor;
    private String fgColor;

    public String getFgColor() {
        return fgColor;
    }

    public void setFgColor(String fgColor) {
        this.fgColor = fgColor;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String name;
    List<ContentJson> ads;

    List<CategoryJson> categories;
    List<BrandJson> brands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContentJson> getAds() {
        return ads;
    }

    public void setAds(List<ContentJson> ads) {
        this.ads = ads;
    }


    public List<CategoryJson> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryJson> categories) {
        this.categories = categories;
    }

    public List<BrandJson> getBrands() {
        return brands;
    }

    public void setBrands(List<BrandJson> brands) {
        this.brands = brands;
    }

    public List<ContentJson> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<ContentJson> keywords) {
        this.keywords = keywords;
    }

    public List<ContentJson> getContents() {
        return contents;
    }

    public void setContents(List<ContentJson> contents) {
        this.contents = contents;
    }

    List<ContentJson> keywords;
    List<ContentJson> contents;
}
