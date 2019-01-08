package org.sang.demo.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by CJF on 2018-12-5.
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class personClazz = Class.forName("org.sang.demo.bean.Customer");
        Field[] fArr = personClazz.getDeclaredFields();
        for(Field f : fArr) {
            System.out.println(f.getName());
        }

        Field f = personClazz.getDeclaredField("id");

        Constructor constructor = personClazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object obj = personClazz.getDeclaredConstructor().newInstance();
        f.setAccessible(true);
        f.set(obj, 5L);
        System.out.println(obj.toString());

        Method[] methods = personClazz.getDeclaredMethods();
        for(Method m : methods) {
            System.out.println(m.getName());
        }

        Method m = personClazz.getDeclaredMethod("show1", String.class);
        m.invoke(obj, "show1");

        m = personClazz.getDeclaredMethod("show2");
        m.setAccessible(true);
        m.invoke(obj);

        ArrayList<Integer> strList = new ArrayList<>();
        strList.add(100);
        strList.add(200);

        //	strList.add(100);
        //获取ArrayList的Class对象，反向的调用add()方法，添加数据
        Class listClass = strList.getClass(); //得到 strList 对象的字节码 对象
        //获取add()方法
        Method m2 = listClass.getMethod("add", Object.class);
        //调用add()方法
        m2.invoke(strList, "aaa");

        //遍历集合
        for(Object obj2 : strList) {
            System.out.println(obj2.getClass().getSimpleName());
        }
    }
}
