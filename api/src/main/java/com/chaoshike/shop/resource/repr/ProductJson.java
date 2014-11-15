package com.chaoshike.shop.resource.repr;


public class ProductJson {
    private int id;
    private String name;
    private String summary;
    private String image;
    private int regionId;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    private float salePrice;
    private int category;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

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

    public ProductJson(int id, String name, String summary, String image, int regionId, float salePrice, int category, float marketPrice) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.image = image;
        this.regionId = regionId;
        this.salePrice = salePrice;
        this.category = category;
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

    @Override
    public String toString() {
        return "ProductJson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", image='" + image + '\'' +
                ", regionId=" + regionId +
                ", salePrice=" + salePrice +
                ", category=" + category +
                ", marketPrice=" + marketPrice +
                '}';
    }
}
