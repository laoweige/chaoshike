package com.chaoshike.shop.repository.entity;

/**
 * Created by weizhigang on 14-11-15.
 */
public class LayoutRegion {
    private int layoutId;
    private int regionId;
    private int regionType;

    public int getRegionType() {
        return regionType;
    }

    public void setRegionType(int regionType) {
        this.regionType = regionType;
    }

    private String regionName;
    private String categoryIds;
    private String brandIds;

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
    }

    public String getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(String brandIds) {
        this.brandIds = brandIds;
    }
}
