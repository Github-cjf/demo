package org.sang.demo.test;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by CJF on 2018-5-31.
 */
public class test2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list3;
        for(int i=0; i<1000000; i++){
            list.add(i);
        }
        long t1 = System.currentTimeMillis();
        List<Integer> list2 = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            list2.add(list.get(i) * list.get(i));
        }
        long t2 = System.currentTimeMillis();
        System.out.println("for:"+(t2 -t1));

        t2 = System.currentTimeMillis();

        list3 = list.parallelStream().map(n -> n*n).collect(Collectors.toList());
        System.out.println("stream:"+(System.currentTimeMillis() -t2));

        String x = "1";
        final String a = x;
        System.out.println("a:"+a);
        x = "2";
        System.out.println("a:"+new ObjectId("123"));
        System.out.println("aa="+ org.sang.demo.test.TestFinal.aa);
    }

    public static void getType(String... type){
        if(type.length>0){
            System.out.println("a");
        }else {
            System.out.println(type);
        }
    }
}
