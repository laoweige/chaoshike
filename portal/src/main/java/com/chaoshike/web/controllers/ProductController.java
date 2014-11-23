package com.chaoshike.web.controllers;

import com.chaoshike.web.services.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ApiClient apiClient;
    @RequestMapping(value = "{shop}/product-{id}",method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("shop") String shop,
                                  @PathVariable("id") int id,
                                  HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Map<String,Object> current = new HashMap<>();
        current.put("shop",shop);
        Map<String,Object> product = apiClient.getProductBy(id);
        System.out.println("++++++++++");
        System.out.println(product);
        List<Map<String,Object>> navigation = apiClient.getCategories(String.valueOf(product.get("category")));

        current.put("navigate",navigation.get(navigation.size()-1));
        System.out.println(navigation);

        modelAndView.addObject("current",current);
        modelAndView.addObject("product",product);
        modelAndView.addObject("navigation",navigation);
        modelAndView.setViewName("product");
        return modelAndView;
    }


//,@RequestParam("page") String page
    @RequestMapping(value = "{shop}/c-{category}",method = RequestMethod.GET)
    public ModelAndView buildList(@PathVariable("shop") String shop,
                                  @PathVariable("category") String category,
                                  HttpServletRequest request) throws Exception {
        System.out.println("#######inter buildList######");
        String path = String.format("/%s/c-%s",shop,category);
        Map<String,String> args = new HashMap<>();
        if(category.startsWith("c"))
            args.put("channel",category.substring(1));
        else if(category.startsWith("p"))
            args.put("classId",category.substring(1));
        else
            args.put("category",category);
        path+=".html?type=c";
        System.out.println(args);

        Map<String,String[]> pm=request.getParameterMap();
        int page=1;
        if(pm.containsKey("page"))
            page = Integer.parseInt(pm.get("page")[0]);

        if(pm.containsKey("keyword")){
            args.put("keyword",pm.get("keyword")[0]);
            path+=String.format("&keyword=%s",args.get("keyword"));
        }
        String order="createTime%20desc";
        if(pm.containsKey("order")){
            order = pm.get("order")[0];
            path+=String.format("&order=%s",order);
        }



        List<Map<String,Object>> categories = apiClient.getCategories();

        List<Map<String,Object>> products = apiClient.getProducts(args,order,page,4);

        List<Map<String,Object>> navigation = apiClient.getCategories(category);


        System.out.println(products);
        ModelAndView modelAndView = new ModelAndView();


        Map<String,Object> current = new HashMap<>();
        if(navigation.size()==1){
            current.put("navigate",navigation.get(0));
            //current = navigation.get(0);
        }else{
            current.put("navigate",navigation.get(navigation.size()-1));
        }
        current.put("path",path);
        current.put("page",page);
        current.put("shop",shop);


        System.out.println(current);

        modelAndView.addObject("categories", categories);
        modelAndView.addObject("products", products);
        modelAndView.addObject("navigation",navigation);
        modelAndView.addObject("current",current);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping(value = "{shop}/list",method = RequestMethod.GET)
    public ModelAndView buildListByKeyword(@PathVariable("shop") String shop,
                                  HttpServletRequest request) throws Exception {
        System.out.println("#######inter buildList######");
        String path = String.format("/%s/list",shop);
        Map<String,String> args = new HashMap<>();

        path+=".html?type=p";
        System.out.println(args);

        Map<String,String[]> pm=request.getParameterMap();
        int page=1;
        if(pm.containsKey("page"))
            page = Integer.parseInt(pm.get("page")[0]);

        if(pm.containsKey("keyword")){
            args.put("keyword",pm.get("keyword")[0]);
            path+=String.format("&keyword=%s",args.get("keyword"));
        }
        String order="createTime%20desc";
        if(pm.containsKey("order")){
            order = pm.get("order")[0];
            path+=String.format("&order=%s",order);
        }



        List<Map<String,Object>> categories = apiClient.getCategories();

        List<Map<String,Object>> products = apiClient.getProducts(args,order,page,4);


        System.out.println(products);
        ModelAndView modelAndView = new ModelAndView();


        Map<String,Object> current = new HashMap<>();

        current.put("path",path);
        current.put("page",page);
        current.put("shop",shop);


        System.out.println(current);

        modelAndView.addObject("categories", categories);
        modelAndView.addObject("products", products);

        modelAndView.addObject("current",current);
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
