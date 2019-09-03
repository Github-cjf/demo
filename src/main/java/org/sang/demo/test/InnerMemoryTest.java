package org.sang.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by CJF on 2019/4/24.
 */
public class InnerMemoryTest {
    private final static List<HashMap<String,Object>> l2 = new ArrayList<>();
    private java.util.List<Object> l = new ArrayList<>();
    {
        //增加MyTest对象的内存
        for (int i = 0; i < 1000; i++) {
            l.add(""+ UUID.randomUUID());

        }
    }
    /**
     * 匿名对象模式
     */
    public void test(){
        l2.add(new HashMap<String,Object>(){
            {put("11111111111", "11111111111111");
                put("11111111111", "11111111111111");
                put("11111111111", "11111111111111");
                put("11111111111", "11111111111111");
                put("11111111111", "11111111111111");}
        });
    }
    /**
     * 普通模式
     */
    public void test2(){
        HashMap<String, Object> d = new HashMap<String,Object>();
        d.put("11111111111", "11111111111111");
        d.put("11111111111", "11111111111111");
        d.put("11111111111", "11111111111111");
        d.put("11111111111", "11111111111111");
        d.put("11111111111", "11111111111111");
        l2.add(d);
    }
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("start");
        for (int i = 0; i < 10000; i++) {
//            new InnerMemoryTest().test2();
            new InnerMemoryTest().test();
        }
        System.out.println("end");
        Thread.sleep(200000);
    }
}
