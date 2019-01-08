package org.sang.demo.test;

import java.lang.Thread;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by CJF on 2018-7-18.
 */
public class PoolTest {
    static ExecutorService mScheduledThreadPool = Executors.newScheduledThreadPool(100);

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
//        PoolTest p = new PoolTest();
//        p.test();

        Set<Integer> set = new ConcurrentSkipListSet<>();
        Runnable r = () ->{
            Person p = Person.getInstance();
            set.add(p.hashCode());
//            System.out.println("hashcode:"+p.hashCode());
        };
        for (int i = 0; i < 100000; i++) {
            mScheduledThreadPool.submit(r);
//            Runnable r = () ->{
//                Person p = Person.getInstance();
//                System.out.println("hashcode:"+p.hashCode());
//            };
//            ThreadTest t = new ThreadTest(r);
//            t.start();
        }
        Thread.sleep(5000);
        System.out.println(set.size());
        mScheduledThreadPool.shutdown();
    }

    public void test(){
        Runnable r = () ->{
            org.sang.demo.test.Person p = org.sang.demo.test.Person.getInstance();
            System.out.println("hashcode:"+p.hashCode());
        };
        for (int i = 0; i < 5; i++) {
            mScheduledThreadPool.submit(r);
        }
    }
}
