package org.sang.demo.test;

/**
 * Created by CJF on 2018-7-19.
 */

class SingleTon {

    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;

    private SingleTon() {
        count1++;
        System.out.println("count1:"+count1);
        count2++;
        System.out.println("count2:"+count1);
    }

    public static SingleTon getInstance() {
        return singleTon;
    }

    public static void main(String[] args) {
//        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + count1);
        System.out.println("count2=" + count2);
    }
}

class Test {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + SingleTon.count1);
        System.out.println("count2=" + SingleTon.count2);
    }
}
