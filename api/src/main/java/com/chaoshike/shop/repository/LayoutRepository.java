package com.chaoshike.shop.repository;

import com.chaoshike.shop.repository.entity.Layout;
import com.chaoshike.shop.repository.entity.LayoutContent;
import com.chaoshike.shop.repository.entity.LayoutRegion;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by weizhigang on 14-11-16.
 */
public interface LayoutRepository {
    @Select("select * from LayoutContents where layoutId=#{layout}")
    List<LayoutContent> getContentsBy(int layout);

    @Select("select * from LayoutRegions where layoutId=#{layout}")
    List<LayoutRegion> getRegionBy(int layout);

    @Select("select * from layouts where layoutId=#{layout}")
    Layout getEntity(int layout);

}
