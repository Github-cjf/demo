package org.sang.demo.test;

import org.bson.types.ObjectId;
import org.sang.demo.JsonUtil;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by CJF on 2018-5-31.
 */
public class test2 {
    public static void main(String[] args) throws InterruptedException {
        int a = 123;
        int b = 432;
        a |= b;
        System.out.println(a);
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName()+"==="+Message.getInstance().hashCode());
//            }).start();
//        }
//        String s1 = "abc";
//        String s2 = "a";
//        String s3 = "bc";
//        String s4 = s2 + s3;
//        System.out.println(s1 == s4);
//        List list = new ArrayList(10000);
//        IntStream.range(0, 1000).parallel().forEach(list::add);
////        Vector v = new Vector();
////        list.parallelStream().forEach(System.out::println);
//        System.out.println(list.size());
//        int b[] = IntStream.range(0, 1_000_000).parallel().filter(p -> p % 2 == 0).toArray();
//        System.out.println(b.length);
//        final Object collect = list.parallelStream().collect(Collectors.toList());
//        List<Integer> list = new ArrayList<>();
//        List<Integer> list3;
//        for(int i=0; i<1000000; i++){
//            list.add(i);
//        }
//        long t1 = System.currentTimeMillis();
//        List<Integer> list2 = new ArrayList<>();
//
//        for(int i=0; i<list.size(); i++){
//            list2.add(list.get(i) * list.get(i));
//        }
//        long t2 = System.currentTimeMillis();
//        System.out.println("for:"+(t2 -t1));
//
//        t2 = System.currentTimeMillis();
//
//        list3 = list.parallelStream().map(n -> n*n).collect(Collectors.toList());
//        System.out.println("stream:"+(System.currentTimeMillis() -t2));
//
//        String x = "1";
//        final String a = x;
//        System.out.println("a:"+a);
//        x = "2";
//        System.out.println("a:"+new ObjectId("123"));
//        System.out.println("aa="+ org.sang.demo.test.TestFinal.aa);
//        int b = 0;
//        double d = 0.00d;
//        System.out.println(b == d);
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("a", "12");
//        map.add("a", "34");
//        map.put("b", Arrays.asList("a", "b", "c"));
//        System.out.println(map.get("b"));
//        Person p = new Person();
//        System.out.println(p.hashCode());
//        p = new Person();
//        System.out.println(p.hashCode());

//        System.out.println(String.format("%05d", 2));

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (String.valueOf(user.getStatus()).intern()) {
//                    System.out.println(111);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(222);
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (String.valueOf(user.getStatus()).intern()) {
//                    System.out.println(333);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(444);
//                }
//            }
//        }).start();

      //  System.out.println(a.equals(b));
    }

    public static void getType(String... type){
        if(type.length>0){
            System.out.println("a");
        }else {
            System.out.println(type);
        }
    }
}
