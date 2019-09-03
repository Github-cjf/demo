package org.sang.demo.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by CJF on 2019/6/5.
 */
public class FunctionTest {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(5);
        Consumer<String> f = System.out::println;
        Consumer<String> f2 = n -> System.out.println(n + (i.incrementAndGet()));

        //执行完F后再执行F2的Accept方法
        f.andThen(f2).accept("test");

        //连续执行F的Accept方法
        f.andThen(f2).andThen(f2).andThen(f2).accept("test");

        Function<Integer, String> f1 = t -> t * 2 + "";
        Function<String, String> f22 = t -> t + "aaa";
        System.out.println(f1.andThen(f22).apply(5));

        Predicate<String> p1 = s -> s.equals("a");
        Predicate<String> p2 = s -> s.equals(0);
        System.out.println(p1.and(p2).test("a"));
        int x=2;
        System.out.println("a" + x++);


        int a = (int) Math.ceil(125/10d);
        System.out.println(a);
        IntStream.range(-1, 76).forEach(aaa -> {
            System.out.println((aaa+1)*100);
        });
    }
}
