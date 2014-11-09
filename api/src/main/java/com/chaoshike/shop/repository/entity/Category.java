package com.chaoshike.shop.repository.entity;


import java.util.Date;

public class Category {
    private int categoryId;
    private int channelId;
    private String categoryName;
    private String alias;
    private int status;
    private int parentId;
    private Date createTime;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getChannelId() {
        return channelId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", channelId=" + channelId +
                ", categoryName='" + categoryName + '\'' +
                ", alias='" + alias + '\'' +
                ", status=" + status +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                '}';
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
