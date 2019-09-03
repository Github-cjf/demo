package org.sang.demo.test;

import java.util.Queue;
import java.util.Random;

/**
 * Created by CJF on 2019/4/23.
 */
public class WaitAndNotifyTest extends Thread{
    private final Calculator c;

    public WaitAndNotifyTest(Calculator c) {
        this.c = c;
    }

    public void run() {
        synchronized (c) {
            System.out.println("wait:"+Thread.currentThread().getName());
            try {
                System.out.println(Thread.currentThread() + "等待计算结果。。。");
                c.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "计算结果为：" + c.total);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Calculator calculator = new Calculator();
        //启动三个线程，分别获取计算结果

        WaitAndNotifyTest test = new WaitAndNotifyTest(calculator);
        test.start();
        new WaitAndNotifyTest(calculator).start();
        new WaitAndNotifyTest(calculator).start();
        new WaitAndNotifyTest(calculator).start();
        new WaitAndNotifyTest(calculator).start();
        Thread.sleep(2000);
        //启动计算线程
        calculator.start();


//        Queue<Integer> queue = new LinkedList<>();
//        Provider provider = new Provider(100000, queue, "provider");
//        Consumer consumer = new Consumer(queue, "consumer");
//        provider.start();
//        consumer.start();
//        Thread.sleep(2000);
//        synchronized (queue) {
//            consumer.wait();
//            provider.wait();
//        }
    }

    public static class Calculator extends Thread {
        int total;

        public void run() {
            synchronized (this) {
                for (int i = 0; i < 101; i++) {
                    total += i;
                }

                notify();
            }
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    static class Provider extends Thread{
        private int max_size;
        private final Queue<Integer> queue;


        Provider(int max_size, Queue<Integer> queue, String name) {
            super(name);
            this.max_size = max_size;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    if(queue.size() == max_size) {
                        try {
                            System.out.println("Producing wait .........");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Random r = new Random();
                    int i = r.nextInt();
                    queue.add(i);
                    queue.notify();
                    System.out.println("Producing aa : " + i);
                }
            }
        }
    }

    static class Consumer extends Thread{
        private final Queue<Integer> queue;


        Consumer(Queue<Integer> queue, String name) {
            super(name);
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    if(queue.isEmpty()) {
                        try {
                            System.out.println("Consuming wait.......");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.notify();
                    Integer i = queue.remove();
                    System.out.println("Consuming bb : " + i);

                }

            }
        }
    }
}
