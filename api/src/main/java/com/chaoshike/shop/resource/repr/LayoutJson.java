package com.chaoshike.shop.resource.repr;

import java.util.List;

/**
 * Created by weizhigang on 14-11-15.
 */
public class LayoutJson {
    String name;
    RegionJson topRegion;
    List<RegionJson> regions;

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

    public List<RegionJson> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionJson> regions) {
        this.regions = regions;
    }
}
