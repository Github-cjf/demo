package org.sang.demo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.sang.demo.SexEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * Created by CJF on 2018-5-2.
 */
//@Component
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = {"id"})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;
    @Value("zhangsan")
    private String name;

    private SexEnum sex;

    private int age;
    private Date birth_date;

    private static Person p;

    public static Person getInstance(){

        if(p == null){
            synchronized (Person.class){
                if(p == null){
//                    p = new Person();
                }
            }

        }
        return p;
    }

    public Person(SexEnum sex) {
        this.sex = sex;
    }


    public Person(String id, String name, int age, Date birth_date, SexEnum sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birth_date = birth_date;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birth_date=" + birth_date +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Person person = (Person) o;
//        return Objects.equals(id, person.id) &&
//                Objects.equals(name, person.name);
//    }
//
//    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, name);
    }
}
