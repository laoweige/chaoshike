package com.chaoshike.shop.resource.repr;


public class ProductJson {
    private int id;
    private String name;
    private String summary;
    private String image;
    private float salePrice;

    public ProductJson() {
    }

    public ProductJson(int id, String name, String summary, String image, float salePrice, float marketPrice) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.image = image;
        this.salePrice = salePrice;
        this.marketPrice = marketPrice;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(float marketPrice) {
        this.marketPrice = marketPrice;
    }

    private float marketPrice;
}
