package com.tyb1222.test;

import com.tyb1222.anno.UserAnno;
import com.tyb1222.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(BlockJUnit4ClassRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AnnoTest {

    @Autowired
    private UserService userService;

    @Test
    public void annoTest(){
        String userName = userService.getUserName("12");
        Assert.assertNotNull(null,userName);

    }
}
