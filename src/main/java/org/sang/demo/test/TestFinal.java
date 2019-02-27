package org.sang.demo.test;

import java.util.Calendar;

/**
 * Created by CJF on 2018-7-19.
 */
public class TestFinal {

    private static int bb;
    private static int aa;

    static {
        System.out.println("static块");
        bb = aa;
    }

    {
        System.out.println("构造代码块");
    }
    TestFinal() {
//        owner = new Person();
        System.out.println("构造函数");
    }
    public void modifyOwner(Person p) {
        //下面一行代码是修改final变量，将提示错误，无法修改owner.
        //owner = p;

        //下面两行是修改owner对象的值，这是可以的。
//        owner.setAge(9);
//        owner.setId("123");
        System.out.println("方法块");
    }

    public static void main(String[] args) {
        System.out.println("main方法");
        new TestFinal().modifyOwner(new Person());
        System.out.println(TestFinal.aa);
    }

}



