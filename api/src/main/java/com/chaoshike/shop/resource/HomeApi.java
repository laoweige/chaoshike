package com.chaoshike.shop.resource;

import com.chaoshike.shop.resource.repr.*;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/")
public class HomeApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public List<UriJson> getLayoutForAppBy(@PathParam("id") int id) {
        List<UriJson> uris = new ArrayList<>();
        uris.add(new UriJson("WEB首页","/layout/1"));
        uris.add(new UriJson("App首页","/layout/1-app"));
        uris.add(new UriJson("类别树","/categories"));
        uris.add(new UriJson("频道","/categories/channel-1"));
        uris.add(new UriJson("类别","/categories/1"));
        uris.add(new UriJson("产品详情","/products/1"));
        uris.add(new UriJson("产品列表（搜索）- 参数都是可选的","/products?keyword=牛奶&channel=1&category=1&order=createTime%20desc&page=1&pageSize=10"));
        return uris;
    }
}
