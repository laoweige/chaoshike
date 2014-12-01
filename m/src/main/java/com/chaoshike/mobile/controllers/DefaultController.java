package com.chaoshike.mobile.controllers;

import com.chaoshike.mobile.services.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("index")
public class DefaultController {

    @Autowired
    private ApiClient apiClient;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getHome() throws Exception {
        System.out.println("#######inter home######");
        ModelAndView modelAndView = new ModelAndView();

//        Map<String,Object> layoutMap = apiClient.getLayout(1);
//        List<Map<String,Object>> categories = apiClient.getCategories();
//        List<Map<String,Object>> products = apiClient.getProducts(new HashMap(){{put("channel","1");}},2);
//        System.out.println("@##layoutMap######################@");
//        System.out.println(layoutMap);
//        System.out.println("@##categories######################@");
//        System.out.println(categories);
//        System.out.println("@##products######################@");
//        System.out.println(products);
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.addObject("categories", categories);
//        modelAndView.addObject("topRegion", layoutMap.get("topRegion"));
//        modelAndView.addObject("regions", layoutMap.get("regions"));
//        Map<String,Object> current = new HashMap<>();
//        current.put("shop","qianxi");
//        modelAndView.addObject("current",current);
//
//        modelAndView.setViewName("index");

        return modelAndView;
    }
}
