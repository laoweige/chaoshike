package com.chaoshike.shop.resource.repr;

import java.util.List;

/**
 * Created by weizhigang on 14-11-16.
 */
public class AppLayoutJson {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegionJson getTopRegion() {
        return topRegion;
    }

    public void setTopRegion(RegionJson topRegion) {
        this.topRegion = topRegion;
    }

    public List<AppRegionJson> getRegions() {
        return regions;
    }

    public void setRegions(List<AppRegionJson> regions) {
        this.regions = regions;
    }

    RegionJson topRegion;
    List<AppRegionJson> regions;
}
