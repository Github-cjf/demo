package org.sang.demo.util;

/**
 * Created by CJF on 2019/4/19.
 */
public class ThreadA {
    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
        //启动计算线程
        b.start();
        //线程A拥有b对象上的锁。线程为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者
//        Thread.currentThread().interrupt();
//        Thread.sleep(1000);
        synchronized (b) {
            System.out.println("等待对象b完成计算。。。");
            try {
                System.out.println("等待对象b完成计算。。。");
                //当前线程A等待
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b对象计算的总和是：" + b.total);
        }
    }

    static class ThreadB extends Thread {
        int total;

        public void run() {
            synchronized (this) {

            for (int i = 0; i < 101; i++) {
                    total += i;
                }
                //（完成计算了）唤醒在此对象监视器上等待的单个线程，在本例中线程A被唤醒
                notify();
            }
            System.out.println("run执行完成");
        }
    }
}

