package org.sang.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * Created by CJF on 2018-7-18.
 */
public class ThreadTest {
    static ExecutorService executor = Executors.newFixedThreadPool(5);
    volatile static int a = 0;

    public ThreadTest () {
        TestInt ti = new TestInt();
        reset(ti);
        System.out.println(ti.a);   //2

        System.out.println(ti.list);  //3

        reset(ti.list);
        System.out.println(ti.list); //3,5

        int a = 11;
        reset(a);
        System.out.println(a);   //11
    }

    private void reset(int a) {
        a = 12;
    }

    private void reset(TestInt ti) {
        ti.a = 2;
        List<Integer> list = new ArrayList<>();
        list.add(3);
        ti.list = list;
    }

    private void reset(List<Integer> list) {
        list.add(5);
        List<Integer> temp = new ArrayList<>();
        temp.add(4);
        list = temp;
    }

    static class TestInt {
        int a=1;
        List<Integer> list = new ArrayList<>();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Vector<Thread> threads = new Vector<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
            threads.add(t);
            t.start();
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("执行完毕！");


        Callable<String> c = () -> {
//            System.out.println(System.currentTimeMillis());
            Thread.sleep(5000);
//            Long t = System.currentTimeMillis();
//            System.out.println(t);
            return "123d";
        };

        Future<String> f = executor.submit(c);
        String result = "aaa";
        System.out.println(f.isCancelled());
        result = f.get();
        System.out.println(result);
//        Person p = Person.getInstance();
//        p.setAge(12);
//        System.out.println(p);

//        Thread t1 = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Teststr.tt.test1(Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Teststr.tt.test2(Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executor.submit(t1);
//        executor.submit(t2);
//        executor.shutdown();
//
//        TestInt ti = new TestInt();
//        for(int i=0;i<1000;i++){
//            new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    ti.a ++ ;
//                }
//            }).start();
//        }
//        Thread.sleep(1000);
//        System.out.println(ti.a);

    }



}
