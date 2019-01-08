package org.sang.demo.service;

import org.sang.demo.dao.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * Created by CJF on 2018-8-14.
 */
@Service("test1")
public class TestServiceImpl1 implements TestService{
    @Autowired
    UserJPA userJPA;

    @Override
    public String getData() {

        return "test1";
    }
}
