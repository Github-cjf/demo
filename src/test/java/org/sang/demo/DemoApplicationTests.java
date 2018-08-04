package org.sang.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.demo.test.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    public Person person;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 5; i++) {
            System.out.println("i="+i);
        }
        System.out.println("==测试完毕==");
    }

}
