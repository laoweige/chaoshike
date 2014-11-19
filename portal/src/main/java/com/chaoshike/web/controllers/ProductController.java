package com.chaoshike.web.controllers;

import com.chaoshike.web.services.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ApiClient apiClient;
//,@RequestParam("page") String page
    @RequestMapping(value = "category-{category}",method = RequestMethod.GET)
    public ModelAndView buildList(@PathVariable("category") String category) throws Exception {
        System.out.println("#######inter buildList######");

        List<Map<String,Object>> categories = apiClient.getCategories();

        List<Map<String,Object>> products = apiClient.getProducts(new HashMap(){{put("channel","1");}},2);

        List<Map<String,Object>> navigation = apiClient.getCategories(category);


        System.out.println(products);
        ModelAndView modelAndView = new ModelAndView();

        Map<String,Object> current = null;
        if(navigation.size()==1){
            current = navigation.get(0);
        }else{
            current = navigation.get(navigation.size()-1);
        }


        System.out.println(current);

        modelAndView.addObject("categories", categories);
        modelAndView.addObject("products", products);
        modelAndView.addObject("navigation",navigation);
        modelAndView.addObject("current",current);
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
