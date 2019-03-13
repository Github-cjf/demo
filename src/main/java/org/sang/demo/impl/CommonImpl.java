package org.sang.demo.impl;

import org.sang.demo.inter.CommonInter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by CJF on 2019/2/26.
 */
public class CommonImpl implements CommonInter {
    @Override
    public void say(String name) {
        System.out.println("hello world，"+name);
    }

    public static void main(String[] args) {
//        String a = new String("aa");
//        String b = "aa";
//
//        String c = "a";
//        String d = "a";
//        String e = "a"+"a";
//
//        System.out.println(b == a.intern());
//
//        String s0= "kvill";
//        String s1=new String("kvill");
//        String s2=new String("kvill");
//        System.out.println( s0==s1 );
//        System.out.println( "**********" );
////        s1.intern();
//        s2=s2.intern(); //把常量池中"kvill"的引用赋给s2
//        System.out.println( s0==s1);
//        System.out.println( s0==s1.intern() );
//        System.out.println( s0==s2 );

        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
