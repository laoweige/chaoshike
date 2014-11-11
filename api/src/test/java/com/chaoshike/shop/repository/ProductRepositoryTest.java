package com.chaoshike.shop.repository;

import com.chaoshike.shop.repository.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-test.xml"})
@TransactionConfiguration(transactionManager = "translationManager", defaultRollback = true)
@Transactional
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testQuery() throws Exception {
        Map<String,Object> args = new HashMap<>();
        args.put("channel",1);
        args.put("category",1);
        args.put("keyword","牛奶");
        args.put("order","createtime desc");

        List<Product> products = productRepository.query(args);
        System.out.println(products);
    }
}
