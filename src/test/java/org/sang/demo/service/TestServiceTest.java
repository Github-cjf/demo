package org.sang.demo.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by CJF on 2019/2/28.
 */
public class TestServiceTest {
//        @Autowired
////    public Person person;

//    @Autowired
//    RedisServer redisServer;

    @Qualifier("test1")
    @Autowired
    TestService testService;
    @Test
    public void getData() {
        return ;
    }
}