package com.chaoshike.shop.resource;

import com.chaoshike.shop.repository.UserRepository;
import com.chaoshike.shop.repository.entity.User;
import com.chaoshike.shop.resource.necessity.ApiTest;
import com.chaoshike.shop.resource.necessity.TestBeans;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Administrator on 14-11-4.
 */
public class UsersApiTest extends ApiTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

        userRepository = mock(UserRepository.class);
        TestBeans.replaceBean("userRepository", userRepository);
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAll() throws Exception {



        when(userRepository.All()).thenReturn(new ArrayList() {{
            add(new User(2, "wzg", "123456","130111333",0));
            add(new User(1, "zjs", "567890","130111333",0));
        }});
        Response response = client().target(getBaseUri()).path("users")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
        List<Object> result = response.readEntity(List.class);
        System.out.println(result);
        assertThat(response.getStatus(), is(200));
        assertThat(result.size(), is(2));
    }
}
