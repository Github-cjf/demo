package org.sang.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.demo.service.TestService;
import org.sang.demo.test.Person;
import org.sang.demo.util.RedisServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    public Person person;

    @Autowired
    RedisServer redisServer;

    @Qualifier("test1")
    @Autowired
    TestService testService;
//    @Test
//    public void contextLoads() {
//        System.out.println("result===="+testService.getData());
//    }

    @Test
    public void contextLoads() throws InterruptedException {
        redisServer.set("name", "张三");
        System.out.println("name==="+redisServer.get("name"));

        redisServer.set("name", "李四", 5000L);
        Thread.sleep(3000L);
        System.out.println("name==="+redisServer.get("name"));
        Thread.sleep(3000L);
        System.out.println("name==="+redisServer.get("name"));

        redisServer.set("age11", "张三");
        System.out.println("age==="+redisServer.get("age"));


    }

}
