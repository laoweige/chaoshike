package com.chaoshike.shop.resource;

import com.chaoshi.cache.ExpiryException;
import com.chaoshi.cache.IEntityFactory;
import com.chaoshi.cache.MemoryCache;
import com.chaoshi.util.EnumTimeUnit;
import com.chaoshike.shop.repository.CategoryRepository;
import com.chaoshike.shop.repository.ChannelRepository;
import com.chaoshike.shop.repository.UserRepository;
import com.chaoshike.shop.repository.entity.Category;
import com.chaoshike.shop.repository.entity.Channel;
import com.chaoshike.shop.repository.entity.User;
import com.chaoshike.shop.resource.repr.CategoryJson;
import com.chaoshike.shop.resource.repr.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/categories")
public class CategoriesApi {

    static MemoryCache<List<CategoryJson>> cache = new MemoryCache<>();

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON +"; charset=utf-8")
    public List<CategoryJson> all() {


        List<CategoryJson> ChannelCache=cache.get("channels", new IEntityFactory<List<CategoryJson>>(){
            @Override
            public List<CategoryJson> get(String key) throws ExpiryException {

                System.out.println("从数据库读取数据");
                List<Channel> channels =  channelRepository.All();
                List<Category> categories = categoryRepository.All();

                List<CategoryJson> channelList = new ArrayList<>();
                for(Channel channel:channels){
                    CategoryJson cjson = new CategoryJson(channel.getChannelId(),channel.getChannelName(),0);
                    channelList.add(cjson);
                }
                List<CategoryJson> categoryList = new ArrayList<>();
                List<CategoryJson> subCategoryList = new ArrayList<>();
                for(Category category:categories){
                    CategoryJson cjson = new CategoryJson(category.getCategoryId(),category.getCategoryName(),category.getParentId());
                    if(category.getParentId()==0){
                        categoryList.add(cjson);
                        cjson.setChannelId(category.getChannelId());
                    }else{
                        subCategoryList.add(cjson);
                    }
                }


                for(CategoryJson channel:channelList){
                    List<CategoryJson> subCategories = new ArrayList<>();
                    for(CategoryJson category:categoryList){
                        if(channel.getId()==category.getChannelId()){
                            subCategories.add(category);
                        }
                    }
                    channel.setChildren(subCategories);
                }

                for(CategoryJson category:categoryList){
                    List<CategoryJson> subCategories = new ArrayList<>();
                    for(CategoryJson subCategory:subCategoryList){
                        if(category.getId()==subCategory.getParentId()){
                            subCategories.add(subCategory);
                        }
                    }
                    category.setChildren(subCategories);
                }

                return channelList;
            }

        }, EnumTimeUnit.HOUR.adjustInterval(2));
        //System.out.println(aa);
        return ChannelCache;
    }
}
