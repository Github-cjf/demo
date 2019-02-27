package org.sang.demo.impl;

import org.sang.demo.inter.CommonInter;

/**
 * Created by CJF on 2019/2/26.
 */
public class CommonImpl implements CommonInter {
    @Override
    public void say(String name) {
        System.out.println("hello world，"+name);
    }
}
