package org.sang.demo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.sang.demo.SexEnum;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by CJF on 2018-5-2.
 */
@Component
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "t_user")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    private String name;
    @Enumerated()
    private SexEnum sex;
    private int age;
    private Date birth_date;

    private String address;

    public String getName() {
        return name+"00";
    }

    public Person2 setName(String name) {
        this.name = name + "xx";
        return null;
    }

    public List<String> getData() {
        return Arrays.asList("a", "b");
    }

//    private static Person p;
//
//    public static Person getInstance(){
//
//        if(p == null){
//            synchronized (Person.class){
//                if(p == null){
////                    p = new Person();
//                }
//            }
//
//        }
//        return p;
//    }

    public Person(SexEnum sex) {
        this.sex = sex;
    }


    public Person(long id, String name, int age, Date birth_date, SexEnum sex) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, name);
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(5);
        p1.setId(1);
        Person p2 = new Person();
        p2.setAge(10);
        p2.setId(1);
        System.out.println(p1.equals(p2));


    }
}
