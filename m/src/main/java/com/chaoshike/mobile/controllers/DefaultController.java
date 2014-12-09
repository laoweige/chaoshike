package com.chaoshike.mobile.controllers;

import com.chaoshike.mobile.services.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class DefaultController {

    @Autowired
    private ApiClient apiClient;

    @RequestMapping(value="index",method = RequestMethod.GET)
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
    @RequestMapping(value = "product_{id}",method = RequestMethod.GET)
    public ModelAndView getProduct(@PathVariable("id") int id) throws Exception {
        System.out.println("#######inter product######");
        ModelAndView modelAndView = new ModelAndView();
        Map<String,Object> product = apiClient.getProductBy(id);

        modelAndView.addObject("product",product);
        modelAndView.setViewName("product");
        return modelAndView;

    }
    @RequestMapping(value = "category",method = RequestMethod.GET)
    public ModelAndView goCategory() throws Exception {
        System.out.println("#######goCategorye######");
        List<Map<String,Object>> categories = apiClient.getCategories();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
    @RequestMapping(value = "car",method = RequestMethod.GET)
    public ModelAndView goCar() throws Exception {
        System.out.println("#######goCategorye######");
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
    @RequestMapping(value = "my",method = RequestMethod.GET)
     public ModelAndView goMy() throws Exception {
        System.out.println("#######goCategorye######");
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public ModelAndView gologin() throws Exception {
        System.out.println("#######goCategorye######");
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
    @RequestMapping(value = "products/c-{category}",method = RequestMethod.GET)
    public ModelAndView goProductList(@PathVariable("category") String category,
                                      HttpServletRequest request) throws Exception {
        System.out.println("#######inter buildList######");
        String path = String.format("/list/%s",category);
        Map<String,String> args = new HashMap<>();
        args.put("category",category);
        System.out.println(args);
        path+=".mob?type=c";
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
        List<Map<String,Object>> products = apiClient.getProducts(args,order,page,2);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
