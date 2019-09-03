package org.sang.demo.bean;

import org.sang.demo.inter.Operation;

import java.util.concurrent.TimeUnit;

/**
 * Created by CJF on 2019/2/20.
 */
public class AddOperation extends Operation{
    @Override
    public double getResult() {
        return this.getNum1() + this.getNum2();
    }

    private static volatile Boolean b = false;
    private static int i;
    public static void main(String[] args) throws InterruptedException {

        Runnable r = () -> {
            while (!b) {
                i++;
            }
        };
        Thread t = new Thread(r);
        t.start();
        TimeUnit.SECONDS.sleep(1);
        b = true;
//        change();
        System.out.println(i);
    }

    public static void change() {
        b = true;
    }
}
