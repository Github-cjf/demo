package org.sang.demo.service;

import org.springframework.stereotype.Service;

/**
 * Created by CJF on 2018-8-14.
 */
@Service("test1")
public class TestServiceImpl1 implements TestService{

//    @Autowired
//    UserJPA userJPA;

    @Override
    public String getData() {
//        userJPA.count(Example.of(new Person()));
        return "test1";
    }
}
