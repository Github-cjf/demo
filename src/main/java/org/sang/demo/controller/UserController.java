package org.sang.demo.controller;

import org.sang.demo.SexEnum;
import org.sang.demo.dao.UserJPA;
import org.sang.demo.test.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by CJF on 2019/3/27.
 */
@RestController
@Transactional
public class UserController {
    @Autowired
    private UserJPA userJPA;

    @PersistenceContext
    private EntityManager em;

    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    public void save() {
        Person p = new Person();
        p.setAge(10).setName("sun").setSex(SexEnum.unknown).setBirth_date(new Date());
        userJPA.save(p);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public List<Person> query() {
        List<Person> list = userJPA.findAll();
        System.out.println(list);

        return list;
    }

    @RequestMapping(value = "/findByAttr", method = RequestMethod.GET)
    public List<Person> findByAttr(@RequestParam("name") String name, @RequestParam("sex") SexEnum sex,
                                   @RequestParam("id") long id) {
        //方法名的关键词规则
        List<Person> list = userJPA.findBySex(sex);
        System.out.println("findBySex"+list);
        System.out.println("=================");
        //方法名的关键词规则（Like）
        list = userJPA.findByNameLike("%"+name+"%");
        System.out.println("findByNameLike"+list);
        System.out.println("=================");
        //方法名的关键词规则（LessThan）
        Page page = userJPA.findByIdLessThan(id, PageRequest.of(0, 10));
        System.out.println("findByIdLessThan"+page);
        //手写sql 注意查询字段需要与实体类的构造器一一对应
        list = userJPA.findByAttr(name, sex);
        System.out.println("findByAttr"+list.toString());
        System.out.println("=================");
        //排序
        page = userJPA.findAll(PageRequest.of(0, 10, Sort.by(Sort.Order.desc("age"),Sort.Order.asc("id"))));
        //组装sql查询
        Person p = new Person();
        p.setName("22");
        p.setAge(12);
        p.setSex(SexEnum.male);
//        p.setId(5);
        em.persist(p);



        return list;
    }

}
