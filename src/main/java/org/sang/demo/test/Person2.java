package org.sang.demo.test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by CJF on 2018-12-6.
 */
//@Data
//@Accessors(chain = true)
public class Person2 extends Person{
    private String name = "12";

//    @Override
    public String getName(String name) {
        this.name = name;
        return super.getName();
    }

    @Override
    public Person2 setName(String name) {
        this.name = name;
        return this;
    }

    public static void main(String[] args) {
        Person2 p = new Person2();
        p.setName("44");
        System.out.println(p.getName());
    }
}
