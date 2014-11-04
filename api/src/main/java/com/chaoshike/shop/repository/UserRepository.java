package com.chaoshike.shop.repository;


import com.chaoshike.shop.repository.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRepository {

    @Select("SELECT * FROM User")
    List<User> All();

    @Insert("INSERT INTO [User]" +
            "           ([id]" +
            "           ,[CSUserName]" +
            "           ,[CSUserType]" +
            "           ,[Status])" +
            "     VALUES" +
            "           (#{csUserId}" +
            "           ,#{csUserName}" +
            "           ,#{csUserType}" +
            "           ,#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(User user);

}
