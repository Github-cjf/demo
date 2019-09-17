package org.sang.demo;

import org.sang.demo.test.Person;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * Created by CJF on 2018-7-23.
 */

public class jsonchange {
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static Lock lock = new ReentrantLock();
    private static final String s = "aa";

    public static void main(String[] args) throws InterruptedException {
//        Runnable r = () -> {
//            while (!Thread.currentThread().isInterrupted()) {
//                try {
//                    System.out.println("121");
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
////                    Thread.currentThread().interrupt();
//                }
//            }
//        };
//        Thread t = new Thread(r);
//        t.start();
//        Thread.sleep(1000);
//        t.interrupt();
//        System.out.println("end");

        Stream<Person> userStream = Stream.of(new Person("张三", 18), new Person("张四", 19),
                new Person("张五", 19), new Person("老张", 50));

//        Map<Integer, List<Person>> map = userStream.collect(Collectors.toMap(Person::getAge, user -> {
//            List<Person> l = new ArrayList<>();
//            l.add(user);
//            return l;
//        }, (v1, v2) -> {
//            List<Person> l = new ArrayList<>(v1);
//            l.addAll(v2);
//            return v2;
//        }));
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Runnable r1 = () -> {
            System.out.println("r1 wait");
            try {
                Thread.sleep(5000);
                countDownLatch.countDown();
                System.out.println("r1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            System.out.println("r2 wait");
            try {
                countDownLatch.await();
                System.out.println("r2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        };
        for (int i = 0; i < 5; i++) {
            new Thread(r1).start();
        }
        countDownLatch.await();
        System.out.println("end");
    }


    public static void test(String... s) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        latch.await();
        System.out.println(s[0]);
    }

}

