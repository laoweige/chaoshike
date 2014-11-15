package com.chaoshike.shop.repository.entity;

/**
 * Created by weizhigang on 14-11-16.
 */
public class SpecialProduct {
    private int layoutId;
    private int regionId;
    private int productId;

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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
