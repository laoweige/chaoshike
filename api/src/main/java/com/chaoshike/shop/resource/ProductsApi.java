package com.chaoshike.shop.resource;

import com.chaoshike.shop.repository.ProductRepository;
import com.chaoshike.shop.repository.entity.Product;
import com.chaoshike.shop.resource.repr.CategoryJson;
import com.chaoshike.shop.resource.repr.ProductJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/products")
public class ProductsApi {

    @Autowired
    private ProductRepository productRepository;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public ProductJson detail(@PathParam("id") int id){
        Product product = productRepository.detail(id);
        ProductJson result = new ProductJson(product.getProductId(),
                product.getProductName(),product.getSummary(),product.getImagePath(),
                product.getSalePrice(),product.getSalePrice());
        result.setCategory(product.getCategoryId());
        result.setChannelId(product.getChannelId());
        return result;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public List<ProductJson> search(@QueryParam("channel") int channel,
                                    @QueryParam("classId") int classId,
                                     @QueryParam("category") int category,
                                     @QueryParam("keyword") String keyword,
                                     @QueryParam("order") String order,
                                     @QueryParam("page") int page,
                                     @QueryParam("pageSize") int pageSize) {

        Map<String,Object> args = new HashMap<>();

        System.out.println(keyword);
        System.out.println(order);
        System.out.println(channel);
        System.out.println(category);
        if(channel!=0)
            args.put("channel",channel);
        if(classId!=0)
            args.put("classId",classId);
        if(category!=0)
            args.put("category",category);
        if(keyword!=null)
            args.put("keyword",keyword);
        if(order!=null)
            args.put("order",order);

        if(pageSize!=0)
            args.put("rows",pageSize);

        if(page!=0) {
            int start=(page-1)*pageSize;
            args.put("start", start);
        }

        System.out.println(args);


        List<Product> products = productRepository.query(args);
        List<ProductJson> results = new ArrayList<>();
        for(Product product:products){
            results.add(new ProductJson(product.getProductId(),
                    product.getProductName(),product.getSummary(),product.getImagePath(),
                    product.getSalePrice(),product.getSalePrice()));
        }

        return results;
    }

}
