package com.chaoshike.shop.repository;


import com.chaoshike.shop.repository.entity.Product;
import com.chaoshike.shop.repository.provider.ProductSqlProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
//    @SelectProvider(type = ProductSqlProvider.class, method = "search")
//    List<Product> query(@Param("channel") int channel,
//                        @Param("category") int category,
//                        @Param("keyword") String keyword,
//                        @Param("order") String order);

    @SelectProvider(type = ProductSqlProvider.class, method = "search")
    List<Product> query(Map<String,Object> args);

    @Select("SELECT * FROM Products where productId=#{id}")
    Product detail(int id);

    @Select("SELECT p.*,sp.regionId FROM Products p join SpecialProducts sp on p.productId=sp.productId" +
            " where sp.layoutId=#{layoutId} order by regionId")
    List<Product> specialProducts(int layoutId);
}
