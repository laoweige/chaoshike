package com.chaoshike.shop.repository;

import com.chaoshike.shop.repository.entity.Channel;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ChannelRepository {

    @Select("SELECT * FROM Channels")
    List<Channel> All();

}
