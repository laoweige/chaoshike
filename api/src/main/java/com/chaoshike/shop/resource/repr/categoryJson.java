package com.chaoshike.shop.resource.repr;

import java.util.List;

/**
 * Created by weizhigang on 14-11-9.
 */
public class CategoryJson {

    public CategoryJson(int id, String name, int parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    private int id;
    private String name;
    private int parentId;
    private int channelId;

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "CategoryJson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", channelId=" + channelId +
                ", children=" + children +
                '}';
    }

    public int getParentId() {
        return parentId;

    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    private List<CategoryJson> children;



    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryJson> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryJson> children) {
        this.children = children;
    }
}
