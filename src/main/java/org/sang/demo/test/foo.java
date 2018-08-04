package org.sang.demo.test;

/**
 * Created by CJF on 2018-7-20.
 */
class Foo {
    public static void main(String[] args) {
        staticFunction();
    }

    static Foo st = new Foo();

    static {   //静态代码块
        System.out.println("1");
    }

    {       // 实例代码块
        System.out.println("2");
    }

    Foo() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
//        ObjectOutputStream
//        new ObjectInputStream().readObject()
    }

    int a = 110;    // 实例变量
    static int b = 112;     // 静态变量
}/* Output:
        2
        3
        a=110,b=0
        1
        4
 *///:~

class ConstructorExample {
    public static void main(String... args) {
//        Bar bar = new Bar();
//        System.out.println(bar.getValue());
    }
}
