package com.chaoshike.shop.repository;

import com.chaoshi.util.TimeHepler;
import com.chaoshike.shop.repository.entity.LoginToken;
import com.chaoshike.shop.repository.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-test.xml"})
@TransactionConfiguration(transactionManager = "translationManager", defaultRollback = true)
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAll() throws Exception {
        userRepository.createUser(new User("13910178445","123456"));

        User users = userRepository.login("13910178445","123456");
        System.out.println(users);
        assertThat(users.getMobile(), is("13910178445"));
        User users2 = userRepository.login("13910178445","1111");
        System.out.println(users2);
    }

    @Test
    public void testCreateToken() throws Exception {


        Date expireTime = TimeHepler.parse("2014-12-08 23:40:00");
        LoginToken aa = new LoginToken("UUID", "token", 0, expireTime);
        System.out.println(aa);
        userRepository.createToken(aa);
        LoginToken token1 =  userRepository.findLoginToken("token", new Date());
        System.out.println(expireTime);
        System.out.println(new Date());
        System.out.println(token1);
        LoginToken token2 =  userRepository.findLoginToken("token", TimeHepler.parse("2014-12-8 23:50:00"));
        System.out.println(token2);
    }
}
