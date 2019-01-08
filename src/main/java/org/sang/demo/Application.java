package org.sang.demo;

import org.sang.demo.test.*;
import org.sang.demo.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
@RestController
public class Application {
//    private final Person person;
//
//    @Autowired
//    public Application(Person person) {
//        this.person = person;
//    }
    @Autowired
    BaseValueInject value;

    @Autowired
    MongoTemplate mongoTemplate;


//    @Bean
//    public SpringUtil springUtil(){
//        SpringUtil s = new SpringUtil();
//        s.num = 10;
//        return s;
//    }

    @Bean
    public Person initPerson(){
        Person p = new Person();
        p.setName("王五");
        p.setSex(SexEnum.male);
        return p;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    String index2(Person person) {
//        map.put("hello", "121");
//        map.put("bye", "saunala");
//        System.out.println(person.toString());
//        /*if(true){
//            throw new MyException(ErrorCode.nullCode, ErrorCode.nullCode.getMsg());
//        }*/
//        Criteria criteria =new Criteria();
//        criteria.and("diseaseType").is("STK");
//        Query q = new Query(criteria);
//        List l = mongoTemplate.find(q, Object.class, "drgs_template");
        return person.toString();
    }
}
