package com.chaoshike.shop.repository;


import com.chaoshike.shop.repository.entity.Category;
import com.chaoshike.shop.repository.entity.Channel;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface CategoryRepository {

    @Select("SELECT * FROM Categories")
    List<Category> All();

}

