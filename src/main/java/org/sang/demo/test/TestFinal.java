package org.sang.demo.test;

import java.util.Calendar;

/**
 * Created by CJF on 2018-7-19.
 */
public class TestFinal {
    static {
        System.out.println("static块");
    }
    {
        System.out.println("构造代码块");
    }
//    private final Person owner;
    public static final int aa = 123;
    TestFinal() {
//        owner = new Person();
        System.out.println("构造函数");
    }
    public void modifyOwner(org.sang.demo.test.Person p) {
        //下面一行代码是修改final变量，将提示错误，无法修改owner.
        //owner = p;

        //下面两行是修改owner对象的值，这是可以的。
//        owner.setAge(9);
//        owner.setId("123");
        System.out.println("方法块");
    }

    public static void main(String[] args) {
        System.out.println("main方法");
        new TestFinal().modifyOwner(new org.sang.demo.test.Person());
    }

}

class test{
    public static void main(String[] args) {
        System.out.println("aa="+ TestFinal.aa);
        new TestFinal().modifyOwner(new org.sang.demo.test.Person());
        Calendar c = Calendar.getInstance();
    }
}


