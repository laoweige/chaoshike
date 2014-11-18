package com.chaoshike.web.services;

import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiClient.class);
    private Client client;

    @Value("#{config['api.url']}")
    private String baseUrl;

    public ApiClient() {
        this.client = ClientBuilder.newClient(new ClientConfig());
    }

    public Map<String,Object> getLayout(int id){

        Response response = client.target(baseUrl).path("layouts/"+id).request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        Map<String,Object> entityMap = response.readEntity(Map.class);
        System.out.println(entityMap);

        return entityMap;
    }

    public List<Map<String,Object>> getCategories(){

        Response response = client.target(baseUrl).path("categories").request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        List<Map<String,Object>> entityList = response.readEntity(List.class);

        return entityList;
    }

    public List<Map<String,Object>> getCategories(int id){

        Response response = client.target(baseUrl).path("categories/"+id).request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        List<Map<String,Object>> entityList = response.readEntity(List.class);

        return entityList;
    }

    public List<Map<String,Object>> getProducts(Map<String,String> args,int rows){
        return getProducts(args,"createTime desc",1,rows);
    }

    public List<Map<String,Object>> getProducts(Map<String,String> args,String order,int page,int pageSize){

        WebTarget webTarget = client.target(baseUrl)
                .queryParam("order",order)
                .queryParam("page",page)
                .queryParam("pageSize",pageSize);
        for(String key:args.keySet()){
            webTarget.queryParam(key,args.get(key));
        }
        //webTarget.path("products");
        //webTarget.path("products");
        //webTarget.path("products");
        System.out.println(webTarget.getUri());

        Response response = webTarget.path("products")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        System.out.println(response.getStatus());
        //System.out.println(response.getLocation().toString());

        List<Map<String,Object>> entityList = response.readEntity(List.class);

        for(Object obj:entityList){
            System.out.println(obj.getClass());
        }

        //List<Object> entityList = new ArrayList<>();
        return entityList;
    }

}
