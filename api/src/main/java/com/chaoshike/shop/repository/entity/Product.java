package com.chaoshike.shop.repository.entity;

import java.util.Date;

public class Product {
    private int productId ;
    private int shopId ;
    private int regionId;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    private int channelId;
    private int categoryId;
    private int brandId ;
    private String productName ;
    private String summary ;
    private String imagePath ;
    private float salePrice ;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public int getRepertory() {
        return repertory;
    }

    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private int repertory  ;
    private int status ;
    private Date createTime ;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", shopId=" + shopId +
                ", regionId=" + regionId +
                ", channelId=" + channelId +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                ", productName='" + productName + '\'' +
                ", summary='" + summary + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", salePrice=" + salePrice +
                ", repertory=" + repertory +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
