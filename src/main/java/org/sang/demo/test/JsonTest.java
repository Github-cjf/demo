package org.sang.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CJF on 2019/4/10.
 */
public class JsonTest {
    public static void main(String[] args) throws IOException {
        Person p = new Person();
        p.setId(5);
        p.setName("22");

        String personStr = "{\"id\":5,\"name\":\"2200\",\"sex\":null,\"age\":0,\"birth_date\":null,\"address\":null}";

        //jackson
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(p);

        //fastjson
        String str2 = JSON.toJSONString(p);

        //gson
        Gson gson = new Gson();
        String str3 = gson.toJson(p);

        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);

        System.out.println(mapper.readValue(personStr, Person.class));
        System.out.println(JSON.parseObject(personStr, new TypeReference<Person>(){}));
        System.out.println(gson.fromJson(personStr, Person.class));

        JsonTest.action1();

        int a = 8;
        int b= 2;
        System.out.println(a |= b);
    }

    private static Lock lock = new ReentrantLock();

    private static void action1() {
        sync(JsonTest::action2);
    }

    private static void action2() {
        sync(JsonTest::action3);
    }

    private static void action3() {
        System.out.println("hello world");
    }

    private static void sync(Runnable r) {
        try {
            lock.lock();
            r.run();
            System.out.println(Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }
}
