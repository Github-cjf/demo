package org.sang.demo.impl;

import org.sang.demo.inter.CommonInter;

/**
 * Created by CJF on 2019/2/26.
 * 代理模式
 */
public class ProxyCommon implements CommonInter {
    CommonInter ci = new CommonImpl();

    public static void main(String[] args) {
        CommonInter c = new ProxyCommon();
        c.say("Tom");
    }

    @Override
    public void say(String name) {
        ci.say(name);
        System.out.println("代理者模式");
    }
}
