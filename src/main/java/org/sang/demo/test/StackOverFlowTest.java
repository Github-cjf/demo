package org.sang.demo.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CJF on 2019/2/28.
 */
@Slf4j
public class StackOverFlowTest {
    int count = 0;

    public void test(){
        count++;
//        test();
    }

    public static void main(String[] args) {
        List l = new ArrayList<>();
        StackOverFlowTest  s = new StackOverFlowTest();
        try {
            s.test();
        } catch (Throwable e) {
            System.out.println("count:"+s.count);
            e.printStackTrace();
        }
    }
}
