package org.sang.demo.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by CJF on 2018-5-2.
 */
@Configuration
@Component
@Service
@Repository
public class Person {
    private String id;
    private String name;

    private static Person p;

    public static Person getInstance(){
        if(p == null){
            synchronized (Person.class){
                if(p == null){
                    p = new Person();
                }
            }

        }
        return p;
    }

    public Person() {

    }


    public Person(String id, String name, int age, Date birth_date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birth_date = birth_date;
    }

    private int age;
    private Date birth_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth_date=" + birth_date +
                '}';
    }
}
