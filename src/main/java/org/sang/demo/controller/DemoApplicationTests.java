package org.sang.demo.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.sang.demo.service.TestService;
import org.sang.demo.test.Person;
import org.sang.demo.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class DemoApplicationTests {
//    @Autowired
//    public Person person;

    @Qualifier("test1")
    @Autowired
    TestService testService;

//    @Value("${LoadOrder.str}")
    String value;

    @Autowired
    MongoTemplate mongoTemplate;

//    @Autowired
//    MessageSender messageSender;


    public static void main(String[] args) {
        String[] a1 = new String[]{"a", "b", "c"};
        Integer[] a2 = new Integer[]{1, 2, 3};
        System.out.println(Arrays.stream(a1).flatMap(str -> Arrays.stream(a2).map(i -> str+i)).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/person1", method = RequestMethod.POST)
    public String person(@RequestBody Person person) {
        System.out.println("result===="+testService.getData());
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("dd");
        list.add("c");

        return person.toString();
    }

    @RequestMapping(value = "/testUrl", method = RequestMethod.GET)
    @ResponseBody
    public String testUrl() {
        DruidDataSource re = (DruidDataSource) SpringUtil.getBean("dataSource");
        System.out.println(re.getProxyFilters());
//        messageSender.sendTestMessage("hello world55", 5);
//        Queue q = (Queue) SpringUtil.getBean(Queue.class);
//        List<Object> list = mongoTemplate.find(new Query(), Object.class, "com.ewell.bean.UserBean");
//        System.out.println(list.size());
//
//        SpringUtil sp = SpringUtil.getBean(SpringUtil.class);
//        System.out.println("sp:"+sp.num);
//
//        SpringUtil sp2 = (SpringUtil) SpringUtil.getBean("springUtil");
//        System.out.println("sp2:"+sp2.num);
//
//        Person p = SpringUtil.getBean(Person.class);
//        System.out.println(p);
//
//        Person p2 = (Person) SpringUtil.getBean("initPerson");
//        System.out.println(p2);
//
//        System.out.println("result===="+value);
        Map<String, String> map = new HashMap<>();
        map.put("1","a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        if(map.size() == 3){
            map.put("5", "e");
        }
        for (int i = 0; i < 5; i++) {
            map.put(i+"", i*10+"");
        }
        System.out.println(map);
        return testService.getData();
    }

}
