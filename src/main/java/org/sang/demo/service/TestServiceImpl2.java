package org.sang.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by CJF on 2018-8-14.
 */
@Service()
public class TestServiceImpl2 implements TestService{
    @Override
    @Bean
    public String getData() {
        return "test2";
    }
}
