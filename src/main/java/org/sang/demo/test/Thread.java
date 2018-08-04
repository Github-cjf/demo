package org.sang.demo.test;

import java.util.concurrent.*;

/**
 * Created by CJF on 2018-7-18.
 */
public class Thread {
    static ExecutorService executor = Executors.newFixedThreadPool(5);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = () -> {
//            System.out.println(System.currentTimeMillis());
            java.lang.Thread.sleep(5000);
            Long t = System.currentTimeMillis();
            System.out.println(t);
            return "123d";
        };

        Future<String> f = executor.submit(c);
        String result = f.get();
        System.out.println(result);
        org.sang.demo.test.Person p = org.sang.demo.test.Person.getInstance();
        p.setAge(12);
        System.out.println(p);
    }

}
