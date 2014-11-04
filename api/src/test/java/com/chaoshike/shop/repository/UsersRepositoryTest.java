package com.chaoshike.shop.repository;

import com.chaoshike.shop.repository.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-test.xml"})
@TransactionConfiguration(transactionManager = "translationManager", defaultRollback = true)
@Transactional
public class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void testAll() throws Exception {
        List<User> users = usersRepository.All();
        System.out.println(users);
        assertThat(users.size(), is(2));
    }

    @Test
    public void testSave() throws Exception {

    }
}
