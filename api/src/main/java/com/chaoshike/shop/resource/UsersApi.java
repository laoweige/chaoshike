package com.chaoshike.shop.resource;


import com.chaoshike.shop.repository.UsersRepository;
import com.chaoshike.shop.repository.entity.User;
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
@Path("/users")
public class UsersApi {

    @Autowired
    private UsersRepository usersRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserJson> all() {
        List<User> users =  usersRepository.All();
        List<UserJson> resultUsers = new ArrayList<>();
        for(User user:users){
            resultUsers.add(new UserJson(user.getId(),user.getName(),user.getMobile()));
        }
        return resultUsers;
    }

}
