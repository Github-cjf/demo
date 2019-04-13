package org.sang.demo.test;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class Teststr {
    public static int cnt = 6;

    static {
        cnt = cnt + 9;
    }

    public Teststr() {
        cnt++;
    }

//    @Autowired
//    private Person person;
    public static Teststr tt = new Teststr();

    public class Test2{
        public Test2 aa(){
            Teststr t = new Teststr();
            out();
            return new Test2();
        }
    }

    private void out(){

    }

    public static void main(String[] args) {
        Teststr ttt = new Teststr();
        Teststr.Test2 t = ttt.new Test2();
        Person p1 = new Person();
        p1.setId(1);
        p1.setAge(10);
        p1.setName("12");
        Person p2 = new Person();
        p2.setId(1);
        Person p3 = p1;
//        System.out.println("12"+p1.equals(p2));
//        System.out.println(p1.hashCode()+"--"+p2.hashCode());
//        Field[] fArr = p1.getClass().getDeclaredFields();
//        for(Field f : fArr ){
//            f.setAccessible(true);
//            System.out.println(f.getName()+":"+f.get(p1)+":"+f.getAnnotatedType());
//        }
        String a = new String("1");
        String b = "1";
        System.out.println(a == b);
//        Teststr t = new Teststr();
//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                tt.test1(Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                tt.test2(Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }

    private static void changeVal(Integer a) throws NoSuchFieldException, IllegalAccessException {

        Field f = a.getClass().getDeclaredField("value");
        f.setAccessible(true);
        f.set(a, 100);

    }

    public synchronized static void test1(String threadName) throws InterruptedException {
        System.out.println("===开始1"+threadName+"===");
        Thread.sleep(5000);
        System.out.println("===结束1"+threadName+"===");
    }

    public synchronized void test2(String threadName) throws InterruptedException {
        System.out.println("===开始2"+threadName+"===");
        Thread.sleep(1000);
        System.out.println("===结束2"+threadName+"===");
    }



    static {
        cnt /= 3;
    }

}
