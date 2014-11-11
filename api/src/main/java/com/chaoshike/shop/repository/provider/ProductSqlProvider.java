package com.chaoshike.shop.repository.provider;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.Map;

public class ProductSqlProvider {

    public String search(Map<String, Object> args) {

        String sql="select * from products where status=0";
        if(args.containsKey("channel")){
            sql+=" and channelId=";
            sql+=args.get("channel");
        }
        if(args.containsKey("class")){
            sql+=" and classId=";
            sql+=args.get("class");
        }
        if(args.containsKey("category")){
            sql+=" and categoryId=";
            sql+=args.get("category");
        }
        if(args.containsKey("keyword")){
            sql+=" and productName like '%";
            sql+=args.get("keyword");
            sql+="%'";
        }

        if(args.containsKey("order")){
            sql+=" order by ";
            sql+=args.get("order");
        }

        int start=0;
        int rows=20;
        if(args.containsKey("rows")){
            rows = (int)args.get("rows");
        }

        if(args.containsKey("start")){
            start=(int)args.get("start");

        }

        sql+=" LIMIT ";
        sql+=start;
        sql+=",";
        sql+=rows;
        System.out.println(sql);
        return sql;
    }
}
