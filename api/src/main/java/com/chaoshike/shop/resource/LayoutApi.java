package com.chaoshike.shop.resource;


import com.chaoshike.shop.repository.CategoryRepository;
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
import java.util.List;

@Component
@Path("/layouts")
public class LayoutApi {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LayoutRepository layoutRepository;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public LayoutJson getLayoutBy(@PathParam("id") int id) {
        Layout layout = layoutRepository.getEntity(id);

        List<LayoutContent> contents = layoutRepository.getContentsBy(id);
        List<LayoutRegion> regions = layoutRepository.getRegionBy(id);
        List<Product> products = productRepository.specialProducts(id);

        LayoutJson result = new LayoutJson();
        result.setName(layout.getLayoutName());
        result.setRegions(new ArrayList<RegionJson>());

        List<ProductJson> pjs = new ArrayList<>();
        for (Product product : products) {
            ProductJson pj = new ProductJson(product.getProductId(),
                    product.getProductName(), product.getSummary(), product.getImagePath(),product.getRegionId(),
                    product.getSalePrice(), product.getCategoryId(), product.getSalePrice());
            pjs.add(pj);
        }
        System.out.println(pjs);
        List<ContentJson> cjs = new ArrayList<>();
        for (LayoutContent content : contents) {
            ContentJson cjson = new ContentJson(content.getRegionId(), content.getContentType(), content.getKeyword(), content.getUrl(), content.getImagePath());
            cjs.add(cjson);
        }

        for (LayoutRegion region : regions) {
            RegionJson rj = new RegionJson(region.getRegionId(), region.getRegionName());
            fullInCategories(rj, convert(region.getCategoryIds()));
            fullInProducts(rj, pjs);
            fullInContents(rj, cjs);
            if (region.getRegionType() == 0) {
                result.setTopRegion(rj);
            } else {
                result.getRegions().add(rj);
            }
        }


        return result;
    }

    private void fullInCategories(RegionJson region, List<Integer> ids) {
        List<Category> categories = categoryRepository.allSubCategory();
        List<CategoryJson> cjs = new ArrayList<>();

        for (Category category : categories) {
            if (ids.contains(category.getCategoryId())) {
                CategoryJson cjson = new CategoryJson(category.getCategoryId(), category.getCategoryName(), category.getParentId());

                cjs.add(cjson);
            }
        }
        if (cjs.size() > 0) {
            region.setCategories(cjs);
        }

    }

    private void fullInProducts(RegionJson region, List<ProductJson> products) {

        List<ProductJson> regionProducts = new ArrayList<>();
        region.setProducts(regionProducts);
        for (ProductJson product : products) {
            for (CategoryJson category : region.getCategories()) {
                if (product.getCategory() == category.getId() && product.getRegionId() == region.getId()) {
                    regionProducts.add(product);
                    break;
                }
            }
        }
    }

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
