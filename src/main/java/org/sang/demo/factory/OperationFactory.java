package org.sang.demo.factory;

import org.sang.demo.bean.AddOperation;
import org.sang.demo.bean.Customer;
import org.sang.demo.bean.SubOperation;
import org.sang.demo.inter.Operation;
import org.sang.demo.inter.OperationInter;
import org.sang.demo.test.MyException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by CJF on 2019/2/20.
 */
public class OperationFactory {
    public static Operation getOperation(String symbol) {
        if (symbol.equals("+")) {
            return new AddOperation();
        } else if (symbol.equals("-")) {
            return new SubOperation();
        } else {
            throw new MyException("符号错误");
        }
    }

    public static void main(String[] args) {
        Customer c = new Customer();
        System.out.println(c.toString());
        //简单工厂模式
        Operation op = OperationFactory.getOperation("-");
        op.setNum1(3);
        op.setNum2(5);
        System.out.println(op.getResult());

        //抽象工厂模式
        OperationInter in = new AddOperationFactory();
        Operation op2 = in.getOperation();
        op2.setNum2(2);
        op2.setNum1(5);
        System.out.println(op2.getResult());
        List<String> list = Arrays.asList("a", "b", "c", "a");
        Map<String, String> map = list.stream().collect(Collectors.toMap(s -> s+"1", Function.identity(), (k1, k2) -> k2));
        System.out.println(map);
//        System.out.println(1);
//        Thread t = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//                System.out.println(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t.start();
//        t.join();
//        System.out.println(3);
    }
}
