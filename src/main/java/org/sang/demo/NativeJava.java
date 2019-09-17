package org.sang.demo;

/**
 * Created by CJF on 2019/7/19.
 */
public class NativeJava {
    {
        /**
         * 系统加载其他的语言的函数
         */
        System.load("C:\\Users\\Administrator\\Desktop\\com\\Hello.dll");
    }
    /**
     * 就这个natice关键字.标记了这个接口,看起来像是abstract
     */
    public native void sayHello();


    public static void main(String[] args) {
        new NativeJava().sayHello();
    }
}
