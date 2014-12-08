package com.chaoshike.shop.resource.repr;

import com.chaoshike.shop.repository.entity.Category;

import java.util.List;

/**
 * Created by weizhigang on 14-11-16.
 */
public class AppRegionJson {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private List<CategoryJson> categories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryJson> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryJson> categories) {
        this.categories = categories;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    private String imagePath;
}
