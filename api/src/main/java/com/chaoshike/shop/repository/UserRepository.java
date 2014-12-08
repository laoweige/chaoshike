package com.chaoshike.shop.repository;


import com.chaoshike.shop.repository.entity.LoginToken;
import com.chaoshike.shop.repository.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface UserRepository {

    @Select("SELECT * FROM Users where mobile=#{mobile} and password=#{password} LIMIT 0,1")
    User login(@Param("mobile") String mobile,
               @Param("password") String password);

    @Select("SELECT * FROM Users")
    List<User> All();

    @Insert("INSERT INTO Users (name,password,email,mobile,status,integral,createTime,loginTime) " +
            "VALUES(#{name},#{password},#{email},#{mobile},#{status},#{integral},#{createTime},#{loginTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createUser(User user);


    @Select("SELECT * FROM LoginToken where token=#{token} and expireTime>#{now} LIMIT 0,1")
    LoginToken findLoginToken(@Param("token") String token,@Param("now") Date now);

    @Insert("INSERT INTO LoginToken (UUID,token,platform,expireTime,createTime) VALUES" +
            " (#{UUID},#{token},#{platform},#{expireTime},#{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createToken(LoginToken token);

}
