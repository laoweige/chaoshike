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
        return result;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public List<ProductJson> search(@QueryParam("channel") int channel,
                                     @QueryParam("category") int category,
                                     @QueryParam("keyword") String keyword,
                                     @QueryParam("order") String order) {

        Map<String,Object> args = new HashMap<>();

        System.out.println(keyword);
        System.out.println(order);

        if(channel!=0)
            args.put("channel",channel);
        if(category!=0)
            args.put("category",category);
        if(keyword!=null)
            args.put("keyword",keyword);
        if(order!=null)
            args.put("order",order);

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
