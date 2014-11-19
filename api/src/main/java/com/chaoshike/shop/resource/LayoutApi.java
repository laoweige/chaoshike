package com.chaoshike.shop.resource;


import com.chaoshi.cache.ExpiryException;
import com.chaoshi.cache.IEntityFactory;
import com.chaoshi.cache.MemoryCache;
import com.chaoshi.util.EnumTimeUnit;
import com.chaoshike.shop.repository.CategoryRepository;
import com.chaoshike.shop.repository.ChannelRepository;
import com.chaoshike.shop.repository.LayoutRepository;
import com.chaoshike.shop.repository.ProductRepository;
import com.chaoshike.shop.repository.entity.*;
import com.chaoshike.shop.resource.repr.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/layouts")
public class LayoutApi {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LayoutRepository layoutRepository;

    static MemoryCache<LayoutJson> cache = new MemoryCache<>();

    @GET
    @Path("{id}-app")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public AppLayoutJson getLayoutForAppBy(@PathParam("id") int id) {
        LayoutJson layout = buildLayout(id);
        AppLayoutJson appLayout = new AppLayoutJson();
        appLayout.setName(layout.getName());
        appLayout.setTopRegion(layout.getTopRegion());
        appLayout.setRegions(new ArrayList<AppRegionJson>());
        for(RegionJson region:layout.getRegions()){
            AppRegionJson arj = new AppRegionJson();
            arj.setCategories(region.getCategories());
            arj.setName(region.getName());
            if(region.getAds().size()>0) {
                arj.setImagePath(region.getAds().get(0).getImagePath());
            }
            appLayout.getRegions().add(arj);
        }
        return appLayout;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public LayoutJson getLayoutBy(@PathParam("id") int id) {
        return buildLayout(id);
    }

    private LayoutJson buildLayout(int id) {
        final int layoutId = id;
        LayoutJson layoutJson = cache.get("layout_" + id, new IEntityFactory<LayoutJson>() {
            @Override
            public LayoutJson get(String key) throws ExpiryException {


                Layout layout = layoutRepository.getEntity(layoutId);
                List<LayoutContent> contents = layoutRepository.getContentsBy(layoutId);
                List<LayoutRegion> regions = layoutRepository.getRegionBy(layoutId);
                List<Product> products = productRepository.specialProducts(layoutId);

                LayoutJson result = new LayoutJson();
                result.setName(layout.getLayoutName());
                result.setRegions(new ArrayList<RegionJson>());

                List<ProductJson> pjs = new ArrayList<>();
                for (Product product : products) {
                    ProductJson pj = new ProductJson(product.getProductId(),
                            product.getProductName(), product.getSummary(), product.getImagePath(), product.getRegionId(),
                            product.getSalePrice(), product.getCategoryId(), product.getSalePrice());
                    pj.setChannelId(product.getChannelId());
                    pjs.add(pj);
                }
                System.out.println(pjs);
                List<ContentJson> cjs = new ArrayList<>();
                for (LayoutContent content : contents) {
                    ContentJson cjson = new ContentJson(content.getRegionId(), content.getContentType(), content.getKeyword(), content.getUrl(), content.getImagePath());
                    cjs.add(cjson);
                }
                Map<Integer,String> bgMap=new HashMap<Integer,String>(){{
                    put(2,"#FAB709");
                    put(3,"#67bbea");
                    put(4,"#7CBD67");
                    put(1,"#FF6B79");
                }};
                Map<Integer,String> fgMap=new HashMap<Integer,String>(){{
                    put(2,"#FCCD53");
                    put(3,"#95d0f0");
                    put(4,"#A4D195");
                    put(1,"#FF98A2");
                }};
                for (LayoutRegion region : regions) {
                    RegionJson rj = new RegionJson(region.getRegionId(), region.getRegionName());
                    rj.setBgColor(bgMap.get(rj.getId()));
                    rj.setFgColor(fgMap.get(rj.getId()));



                    if (region.getRegionType() == 0) {
                        fullInTopCategories(rj, convert(region.getCategoryIds()), pjs);
                        fullInContents(rj, cjs);
                        result.setTopRegion(rj);
                    } else {
                        fullInCategories(rj, convert(region.getCategoryIds()), pjs);
                        fullInContents(rj, cjs);
                        result.getRegions().add(rj);
                    }
                }
                return result;
            }
        }, EnumTimeUnit.HOUR.adjustInterval(1));
        return layoutJson;
        //return result;
    }

    private void fullInCategories(RegionJson region, List<Integer> ids,List<ProductJson> products) {
        List<Category> categories = categoryRepository.allSubCategory();
        List<CategoryJson> cjs = new ArrayList<>();

        for (Category category : categories) {
            if (ids.contains(category.getCategoryId())) {
                CategoryJson cjson = new CategoryJson(category.getCategoryId(), category.getCategoryName(), category.getParentId());

                cjs.add(cjson);
                cjson.setProducts(new ArrayList<ProductJson>());
            }
        }


        for (ProductJson product : products) {
            for (CategoryJson category : cjs) {
                if (product.getCategory() == category.getId() && product.getRegionId() == region.getId()) {
                    category.getProducts().add(product);
                    break;
                }
            }
        }

        if (cjs.size() > 0) {
            region.setCategories(cjs);
        }

    }

    private void fullInTopCategories(RegionJson region, List<Integer> ids,List<ProductJson> products) {
        List<Channel> channels = channelRepository.All();
        List<CategoryJson> cjs = new ArrayList<>();

        for (Channel channel : channels) {
            if (ids.contains(channel.getChannelId())) {
                CategoryJson cjson = new CategoryJson(channel.getChannelId(), channel.getChannelName(), 0);

                cjs.add(cjson);
                cjson.setProducts(new ArrayList<ProductJson>());
            }
        }


        for (ProductJson product : products) {
            for (CategoryJson category : cjs) {
                if (product.getChannelId() == category.getId() && product.getRegionId() == region.getId()) {

                    category.getProducts().add(product);
                    break;
                }
            }
        }

        if (cjs.size() > 0) {
            region.setCategories(cjs);
        }

    }

//    private void fullInProducts(RegionJson region, List<ProductJson> products) {
//
//        List<ProductJson> regionProducts = new ArrayList<>();
//        region.setProducts(regionProducts);
//        for (ProductJson product : products) {
//            for (CategoryJson category : region.getCategories()) {
//                if (product.getCategory() == category.getId() && product.getRegionId() == region.getId()) {
//                    regionProducts.add(product);
//                    break;
//                }
//            }
//        }
//    }

    private void fullInContents(RegionJson region, List<ContentJson> contents) {

        List<ProductJson> regionProducts = new ArrayList<>();
        List<ContentJson> ads = new ArrayList<>();
        List<ContentJson> tags = new ArrayList<>();
        List<ContentJson> imageTexts = new ArrayList<>();
        region.setAds(ads);
        region.setKeywords(tags);
        region.setContents(imageTexts);
        for (ContentJson content : contents) {
            if (content.getType() == 0 && content.getRegionId() == region.getId()) {
                ads.add(content);
                continue;
            }
            if (content.getType() == 1 && content.getRegionId() == region.getId()) {
                tags.add(content);
                continue;
            }
            if (content.getType() == 2 && content.getRegionId() == region.getId()) {
                imageTexts.add(content);
                continue;
            }
        }
    }

    private List<Integer> convert(String content) {
        List<Integer> ids = new ArrayList<>();
        String[] sub = content.split(",");
        for (String v : sub) {
            ids.add(Integer.valueOf(v));
        }
        return ids;
    }
}
