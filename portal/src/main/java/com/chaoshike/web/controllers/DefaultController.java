package com.chaoshike.web.controllers;

import com.chaoshike.web.services.ApiClient;
import org.glassfish.jersey.client.ClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

        Map<String,Object> layoutMap = apiClient.getLayout(1);
        List<Map<String,Object>> categories = apiClient.getCategories();
        List<Map<String,Object>> products = apiClient.getProducts(new HashMap(){{put("channel","1");}},2);
        System.out.println("@##layoutMap######################@");
        System.out.println(layoutMap);
        System.out.println("@##categories######################@");
        System.out.println(categories);
        System.out.println("@##products######################@");
        System.out.println(products);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("categories", categories);
        modelAndView.addObject("topRegion", layoutMap.get("topRegion"));
        modelAndView.addObject("regions", layoutMap.get("regions"));
        Map<String,Object> current = new HashMap<>();
        current.put("shop","qianxi");
        modelAndView.addObject("current",current);

        modelAndView.setViewName("index");

        return modelAndView;
    }
}
